package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallRandomNumberTest {
    @Test
    @DisplayName("정답은 3자리의 수로 이루어져있다")
    public void lengthOfAnswer() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.initialize();

        // when
        String answer = baseBallRandomNumber.getNumber();

        // then
        assertEquals(3, answer.length());
    }

    @Test
    @DisplayName("정답의 각 자리의 수는 서로 다르다")
    public void eachDigitsAreDifferent() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.initialize();

        // when
        String answer = baseBallRandomNumber.getNumber();

        // then
        assertNotEquals(answer.charAt(0), answer.charAt(1));
        assertNotEquals(answer.charAt(0), answer.charAt(2));
        assertNotEquals(answer.charAt(1), answer.charAt(2));
    }

    @Test
    @DisplayName("정답은 초기화할 때마다 랜덤하게 생성된다")
    public void answerIsGeneratedRandomly() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();

        // when
        baseBallRandomNumber.initialize();
        String answer1 = baseBallRandomNumber.getNumber();

        baseBallRandomNumber.initialize();
        String answer2 = baseBallRandomNumber.getNumber();

        // then
        assertNotEquals(answer1, answer2);
    }

    @Test
    @DisplayName("정답 확인 - 사용자 입력이 정답과 일치하면 true")
    public void guessFail() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.initialize();

        // when
        String answer = baseBallRandomNumber.getNumber();
        boolean result = baseBallRandomNumber.isCorrect(answer);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("정답 확인 - 사용자 입력이 정답과 일치하지 않으면 false")
    public void guessSuccess() {
        // given
        String notAnswer = "111";
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.initialize();

        // when
        boolean result = baseBallRandomNumber.isCorrect(notAnswer);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("숫자와 자리수가 일치하면 스트라이크이다")
    public void strike() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.setNumber("123");

        // when, then
        assertEquals(1, baseBallRandomNumber.getStrikeCount("111"));
        assertEquals(1, baseBallRandomNumber.getStrikeCount("222"));
        assertEquals(1, baseBallRandomNumber.getStrikeCount("333"));

        assertEquals(2, baseBallRandomNumber.getStrikeCount("122"));
        assertEquals(2, baseBallRandomNumber.getStrikeCount("223"));
        assertEquals(2, baseBallRandomNumber.getStrikeCount("133"));

        assertEquals(3, baseBallRandomNumber.getStrikeCount("123"));
    }

    @Test
    @DisplayName("숫자가 일치해도 자리수가 맞지 않으면 스트라이크가 아니다")
    public void notStrike() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.setNumber("123");

        // when, then
        assertEquals(0, baseBallRandomNumber.getStrikeCount("312"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("231"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("311"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("212"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("331"));
    }

    @Test
    @DisplayName("숫자가 일치하지 않으면 스트라이크가 아니다")
    public void notStrike2() {
        // given
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.setNumber("123");

        // when, then
        assertEquals(0, baseBallRandomNumber.getStrikeCount("456"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("567"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("678"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("789"));
        assertEquals(0, baseBallRandomNumber.getStrikeCount("890"));
    }

    @DisplayName("정답이면 3 스트라이크이다")
    public void threeStrike() {
        // given
        String answer = "123";
        BaseBallRandomNumber baseBallRandomNumber = new BaseBallRandomNumber();
        baseBallRandomNumber.setNumber(answer);

        // when, then
        assertTrue(baseBallRandomNumber.isCorrect(answer));
        assertEquals(3, baseBallRandomNumber.getStrikeCount(answer));
    }
}
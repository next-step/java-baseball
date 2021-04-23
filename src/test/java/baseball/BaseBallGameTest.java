package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {
    @Test
    @DisplayName("정답은 3자리의 수로 이루어져있다")
    public void lengthOfAnswer() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.initializeAnswer();

        // when
        String answer = baseBallGame.getAnswer();

        // then
        assertEquals(3, answer.length());
    }

    @Test
    @DisplayName("정답의 각 자리의 수는 서로 다르다")
    public void eachDigitsAreDifferent() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.initializeAnswer();

        // when
        String answer = baseBallGame.getAnswer();

        // then
        assertNotEquals(answer.charAt(0), answer.charAt(1));
        assertNotEquals(answer.charAt(0), answer.charAt(2));
        assertNotEquals(answer.charAt(1), answer.charAt(2));
    }

    @Test
    @DisplayName("정답은 초기화할 때마다 랜덤하게 생성된다")
    public void answerIsGeneratedRandomly() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();

        // when
        baseBallGame.initializeAnswer();
        String answer1 = baseBallGame.getAnswer();

        baseBallGame.initializeAnswer();;
        String answer2 = baseBallGame.getAnswer();

        // then
        assertNotEquals(answer1, answer2);
    }

    @Test
    @DisplayName("정답 확인 - 사용자 입력이 정답과 일치하면 true")
    public void guessFail() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.initializeAnswer();

        // when
        String answer = baseBallGame.getAnswer();

        // then
        assertTrue(baseBallGame.isCorrect(answer));
    }

    @Test
    @DisplayName("정답 확인 - 사용자 입력이 정답과 일치하지 않으면 false")
    public void guessSuccess() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.initializeAnswer();

        // when
        String notAnswer = "111";

        // then
        assertFalse(baseBallGame.isCorrect(notAnswer));
    }
}
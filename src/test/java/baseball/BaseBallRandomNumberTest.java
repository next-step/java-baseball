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
}
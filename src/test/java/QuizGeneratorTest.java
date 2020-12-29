import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuizGeneratorTest {

    private final int ANSWER_LENGTH = 3;

    QuizGenerator quizGenerator = new QuizGenerator(ANSWER_LENGTH);

    @DisplayName("퀴즈 생성기는 항상 1~9 사이의 숫자만 가지는 정해진 길이의 수 생성한다.")
    @Test
    void quizGeneratorNumberTest() {
        for(int i=0; i<10000;i++) {
            String randomAnswer = String.valueOf(quizGenerator.generate());

            assertThat(randomAnswer.length()).isEqualTo(ANSWER_LENGTH);
            assertThat(isOutOfRange(randomAnswer)).isEqualTo(false);
        }
    }

    boolean isOutOfRange(String randomAnswer) {
        for(int i = 0; i < randomAnswer.length(); i++) {
            char digit = randomAnswer.charAt(i);

            if(digit < '1' || digit > '9') return true;
        }

        return false;
    }
}

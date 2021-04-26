import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RightAnswerTest {

    @DisplayName("값 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void correctTest(String input) {
        RightAnswer rightAnswer = new RightAnswer(input);
        assertThat(rightAnswer.getNumber()).isEqualTo(input);
    }

    @DisplayName("상태 변경 테스트")
    @Test
    void correctTest() {
        RightAnswer rightAnswer = new RightAnswer("123");
        assertThat(rightAnswer.isCorrect()).isFalse();

        rightAnswer.setCorrect();
        assertThat(rightAnswer.isCorrect()).isTrue();
    }
}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerRuleTest {

    @ParameterizedTest
    @ValueSource(strings = {"111", "1", "12"})
    public void negativeAnswerSetTests(String userInput) {
        AnswerRule answerRule = new AnswerRule();

        assertThat(answerRule.isValidate(userInput)).isEqualTo(false);
    }

    @Test
    public void positiveAnswerSetTests() {
        AnswerRule answerRule = new AnswerRule();

        assertThat(answerRule.isValidate("123")).isEqualTo(true);
    }
}
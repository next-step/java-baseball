package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {

    @ParameterizedTest
    @CsvSource(value = {"123,123,3,0", "123,321,1,2", "123,312,0,3",
            "123,125,2,0", "123,142,1,1", "123,932,0,2",
            "123,145,1,0", "123,451,0,1", "123,456,0,0",})
    void validateHintTest(String input1, String input2, String expectedStrike, String expectedBall) {
        Number number1 = new Number(input1);
        Number number2 = new Number(input2);

        Hint hint = new Hint(number1, number2);
        assertThat(hint).isNotNull();

        assertThat(hint.getStrikeCount()).isEqualTo(Integer.parseInt(expectedStrike));
        assertThat(hint.getBallCount()).isEqualTo(Integer.parseInt(expectedBall));
    }
}

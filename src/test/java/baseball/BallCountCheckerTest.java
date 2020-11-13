package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountCheckerTest {

    private String answer;

    @BeforeEach
    public void setUp(){
        this.answer = "713";
    }

    @ParameterizedTest
    @CsvSource(value = {"123:1S1B", "145:0S1B", "671:0S2B", "216:1S0B", "713:3S0B"}, delimiter = ':')
    public void checkNumber(final String number, final String expected){
        String result = BallCountChecker.check(number, this.answer);

        assertThat(result).isEqualTo(expected);
    }
}

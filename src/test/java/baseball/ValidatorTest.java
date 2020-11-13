package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"123:true", "012:true", "abc:false", ":false"}, delimiter = ':')
    public void isNumber(final String input, final boolean expected){
        assertThat(Validator.isNumber(input)).isEqualTo(expected);
    }
}

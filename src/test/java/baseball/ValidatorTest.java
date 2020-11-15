package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {

	@DisplayName("문자가 숫자 형식인지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"123:true", "012:true", "abc:false", ":false"}, delimiter = ':')
	public void isNumber(final String input, final boolean expected) {
		assertThat(Validator.isNumber(input)).isEqualTo(expected);
	}

	@DisplayName("문자가 길이가 3자리인지 확인")
	@ParameterizedTest
	@CsvSource(value = {"123:true", "abc:true", ":false", "1:false"}, delimiter = ':')
	public void isLength3(final String input, final boolean expected) {
		assertThat(Validator.isLength3(input)).isEqualTo(expected);
	}

	@DisplayName("문자가 숫자 1 혹인 2 인지 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:false", ":false", "sav:false"}, delimiter = ':')
	public void isNumber1Or2(final String input, final boolean expected) {
		assertThat(Validator.isNumber1Or2(input)).isEqualTo(expected);
	}

	@DisplayName("문자 중에 중복된게 있는지 확인")
	@ParameterizedTest
	@CsvSource(value = {"123:true", "234:true", "111:false", "112:false"}, delimiter = ':')
	public void isDuplicate(final String input, final boolean expected){
		assertThat(Validator.isDuplicate(input)).isEqualTo(expected);
	}
}

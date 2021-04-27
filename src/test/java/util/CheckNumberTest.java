package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CheckNumberTest {

	@ParameterizedTest
	@CsvSource(value = {"223:false", "123:true", "1234:false"}, delimiter = ':')
	@DisplayName("User Number Check Test")
	void testCheckNumber(String tmpNumber, boolean expected) {
		CheckNumber ckNum = new CheckNumber();
		assertThat(expected).isEqualTo(ckNum.checkNumber(tmpNumber));
	}

}
	
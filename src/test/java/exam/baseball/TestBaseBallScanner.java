package exam.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestBaseBallScanner {

	@ParameterizedTest
	@CsvSource(value = {
		"123:true", // ok
		"456:true", // ok
		"654:true", // ok, 역순
		"789:true", // ok
		"120:false", // x, 0 포함
		"222:false", // x, 중복
		"1234:false",// x, 긴 문자열 
		"12:false",  // x, 짧은 문자열
		":false",	 // x, emtpy
		" :false",	 // x, space
		"xxx:false", // x, not number
		"1xx:false", // x, number with text
	}, delimiter = ':')
	void test_숫자_입력의_포맷을_확인한다(String input, boolean isCorrect) {
		if (input == null) {
			input = "";
		}
		assertThat(BaseBallScanner.incorrectBaseballInput(input))
			.isNotEqualTo(isCorrect);
	}

}

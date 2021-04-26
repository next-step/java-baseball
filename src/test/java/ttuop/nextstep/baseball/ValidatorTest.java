package ttuop.nextstep.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {

	@ParameterizedTest
	@CsvSource({"123,true", "111,false", ",false", "1,false", "12,false", "1234,false"})
	@DisplayName("문자열 유효성 체크 테스트")
	void testValidateQuestion(String input, boolean expected) {
		boolean result = Validator.validateQuestion(input);

		assertEquals(result, expected);
	}

	@ParameterizedTest
	@CsvSource({"1,true", "2,true", ",false", "3,false", "a,false", "12,false"})
	@DisplayName("메뉴 번호 유효성 체크 테스트")
	void testValidateMenu(String input, boolean expected) {
		boolean result = Validator.validateMenu(input);

		assertEquals(result, expected);
	}

}

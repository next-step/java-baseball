package io.github.sejoung.baseball.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallValidatorTest {

	@DisplayName("정상")
	@Test
	void ok() {
		BaseBallValidator validator = new BaseBallValidator("123", false);
		validator.valid();
	}

	@DisplayName("문자열 테스트")
	@Test
	void integerCheck() {
		BaseBallValidator validator = new BaseBallValidator("1ab2", false);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자만 입력 가능합니다.");

	}

	@DisplayName("3자리수 초과일때")
	@Test
	void lengthCheckOver() {
		BaseBallValidator validator = new BaseBallValidator("1234", false);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("3 자리수만 입력 가능합니다.");
	}

	@DisplayName("3자리수 미만일때")
	@Test
	void lengthCheck() {
		BaseBallValidator validator = new BaseBallValidator("12", false);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("3 자리수만 입력 가능합니다.");
	}

	@DisplayName("중복체크")
	@Test
	void duplicateCheck() {
		BaseBallValidator validator = new BaseBallValidator("111", false);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 숫자가 있습니다.");
	}

	@DisplayName("숫자입력")
	@Test
	void rangeCheck() {
		BaseBallValidator validator = new BaseBallValidator("103", false);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("0은 입력되지 않습니다.");
	}

	@DisplayName("3스트라이크 일때 숫자범위")
	@ParameterizedTest
	@CsvSource(value = {"0,3,4,5,6,7,8,9"})
	void rangeCheckEnd(String input) {
		BaseBallValidator validator = new BaseBallValidator(input, true);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("게임을 새로 시작 하려면 1,종료 하려면 2를 입력하세요.");
	}

	@DisplayName("3스트라이크 일때 자리수")
	@Test
	void lengthCheckEnd() {
		BaseBallValidator validator = new BaseBallValidator("123", true);
		assertThatThrownBy(validator::valid).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1 자리수만 입력 가능합니다.");
	}

}

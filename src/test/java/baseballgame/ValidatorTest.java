package baseballgame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {

	private Validator validator;

	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	@DisplayName("1~9 로 이루어진 서로 다른 3자리수 유효성 체크")
	@ParameterizedTest
	@CsvSource(value = {"'':false", "012:false", "a23:false", "122:false", "1123:false", "3456:false",
		"123:true"}, delimiter = ':')
	void validateStringNumbers(String value, boolean result) {
		List<String> stringNumbers = Arrays.asList(value.split(""));
		boolean validateResult = validator.validateStringNumbers(stringNumbers);

		assertThat(validateResult).isEqualTo(result);
	}

	@DisplayName("스트라이크, 볼 개수 유효성 체크")
	@ParameterizedTest
	@CsvSource(value = {"2:2:false", "2:1:false", "3:1:false", "0:0:true", "1:0:true", "1:1:true", "2:0:true",
		"0:3:true", "3:0:true"}, delimiter = ':')
	void validateStrikeAndBallCounts(int strikeCount, int ballCount, boolean result) {
		boolean validate = validator.validateStrikeAndBallCounts(strikeCount, ballCount);

		assertThat(validate).isEqualTo(result);
	}

	@DisplayName("게임 재시작 또는 종료 상태 유효성 체크")
	@ParameterizedTest
	@CsvSource(value = {"'':false", "abc:false", "a12!@#:false", "0:false", "1:true", "2:true"}, delimiter = ':')
	void validateRestartOrEndStatus(String restartOrEndStatus, boolean result) {
		boolean validate = validator.validateRestartOrEndStatus(restartOrEndStatus);

		assertThat(validate).isEqualTo(result);
	}
}

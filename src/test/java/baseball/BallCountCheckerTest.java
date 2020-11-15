package baseball;

import static org.assertj.core.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallCountCheckerTest {

	private String answer;

	@BeforeEach
	public void setUp() {
		this.answer = "713";
	}

	@DisplayName("입력받은 숫자로 볼카운트 확인 로직 테스트")
	@ParameterizedTest
	@CsvSource(value = {"123:1:1", "145:0:1", "671:0:2", "216:1:0", "713:3:0"}, delimiter = ':')
	public void checkNumber(final String input, final int expectedStrike, final int expectedBall) {
		BallCount result = BallCountChecker.check(input, this.answer);

		assertThat(result).isEqualToComparingFieldByField(new BallCount(expectedStrike, expectedBall));
	}

	@DisplayName("볼카운트 확인전 입력값이 올바른지 확인 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "", "a", "abc", "ㄱㄴㄷ"})
	public void inputValidation(String input) {
		assertThatThrownBy(() -> {
			BallCount result = BallCountChecker.check(input, this.answer);
		}).isInstanceOf(InvalidParameterException.class);
	}
}

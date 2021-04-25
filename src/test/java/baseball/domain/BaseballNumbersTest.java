package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumbersTest {

	@Test
	@DisplayName("야구 숫자 리스트가 3개가 아니면 야구 숫자 묶음을 생성할 수 없다.")
	void failToCreateBaseballNumbersIfListIsNotSize3() {
		assertThatThrownBy(() -> BaseballNumbers.newBaseballNumbers(
				Arrays.asList(new BaseballNumber(1), new BaseballNumber(2))
			)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("중복된 숫자가 존재할 경우 야구 숫자 묶음을 생성할 수 없다.")
	void failToCreateBaseballNumbersIfDuplicateNumberIsExists() {
		assertThatThrownBy(() -> BaseballNumbers.newBaseballNumbers(
			Arrays.asList(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(2))
			)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("야구 숫자 묶음을 생성할 수 없다.")
	void successToCreateBaseballNumbers() {
		BaseballNumbers baseballNumbers = BaseballNumbers.newBaseballNumbers(
			Arrays.asList(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3))
		);

		assertThat(baseballNumbers).isInstanceOf(BaseballNumbers.class);
	}

}

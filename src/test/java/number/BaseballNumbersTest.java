package number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumbersTest {

	private BaseballNumbers baseballNumbers;

	@BeforeEach
	void setIp() {
		baseballNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("야구 숫자의 크기가 3이 아닌 경우")
	void validateSuitableSize() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new BaseballNumbers(Arrays.asList(1, 2));
		}).withMessage("세자리의 수가 아닙니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new BaseballNumbers(Arrays.asList(1, 2, 3, 4));
		}).withMessage("세자리의 수가 아닙니다.");;
	}

	@Test
	@DisplayName("야구 숫자에 중복이 존재하는 경우")
	void validateDuplication() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new BaseballNumbers(Arrays.asList(3, 3, 1));
		}).withMessage("숫자에 중복이 존재합니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new BaseballNumbers(Arrays.asList(1, 3, 1));
		}).withMessage("숫자에 중복이 존재합니다.");
	}

	@Test
	@DisplayName("야구 숫자가 1~9 사이 숫자가 아닌 경우")
	void validateBetweenOneAndNine() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new BaseballNumbers(Arrays.asList(1, 2, 0));
		}).withMessage("1~9의 숫자로 구성되어 있지 않습니다.");
	}

	@Test
	void getBaseballNumbers() {
		assertThat(baseballNumbers.getBaseballNumbers()).isEqualTo(baseballNumbers.getBaseballNumbers());
	}

	@Test
	void size() {
		assertThat(baseballNumbers.size()).isEqualTo(3);
	}

	@Test
	void get() {
		assertThat(baseballNumbers.get(0)).isEqualTo(1);
	}

}

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameValidatorTest {
	@Test
	@DisplayName("세자리인지 확인")
	public void is_three_digit() {
		assertThat(BaseballGameValidator.isLengthThree("123")).isTrue();
		assertThat(BaseballGameValidator.isLengthThree("1234")).isFalse();
	}

	@Test
	@DisplayName("숫자인지 확인")
	public void is_number() {
		assertThat(BaseballGameValidator.isNumbers("123")).isTrue();
		assertThat(BaseballGameValidator.isNumbers("abc")).isFalse();
	}

	@Test
	@DisplayName("종료시 입력이 허용된 숫자인지 확인")
	public void is_allowed_numbers() {
		assertThat(BaseballGameValidator.isAllowedNumbers("1")).isFalse();
		assertThat(BaseballGameValidator.isAllowedNumbers("2")).isFalse();
		assertThat(BaseballGameValidator.isAllowedNumbers("3")).isTrue();
		assertThat(BaseballGameValidator.isAllowedNumbers("a")).isTrue();
	}

	@Test
	@DisplayName("0 이 포함되어 있는지 확인")
	public void is_not_zero_contained() {
		assertThat(BaseballGameValidator.isNotZeroContained("102")).isFalse();
		assertThat(BaseballGameValidator.isNotZeroContained("132")).isTrue();
	}
}

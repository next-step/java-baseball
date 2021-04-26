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
}

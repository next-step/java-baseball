package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.exception.BaseballNumberRangeException;

class BaseballNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {3, 4, 9})
	@DisplayName("같은 값으로 생성한 번호는 같은 값이다.")
	void equality(int number) {
		assertThat(BaseballNumber.valueOf(number))
			.isEqualTo(BaseballNumber.valueOf(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-3, 10, 15, -1})
	@DisplayName("0 ~ 9 사이의 수가 아니면 예외 발생")
	void rangeCheck(int number) {
		assertThatThrownBy(() -> BaseballNumber.valueOf(number))
			.isInstanceOf(BaseballNumberRangeException.class)
			.hasMessage("0 ~ 9 사이의 숫자여야 합니다.");
	}
}
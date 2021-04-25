package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

	@DisplayName("숫자가 범위 1 ~ 9를 벗어난 경우 야구 번호를 생성할 수 없다.")
	@ParameterizedTest
	@ValueSource(ints = { -1, 0, 11 })
	void failToCreateBaseballNumberIfNumberOutOfRange1To9(int number) {
		assertThatThrownBy(() -> new BaseballNumber(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("유효 범위의 숫자일 경우 야구 번호를 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
	void successToCreateBaseballNumber(int number) {
		BaseballNumber baseballNumber = new BaseballNumber(number);
		assertThat(baseballNumber).isInstanceOf(BaseballNumber.class);
	}

	@Test
	@DisplayName("숫자가 같으면 동등한 객체이다.")
	void sameBaseballNumberIfNumberSame() {
		BaseballNumber baseballNumber = new BaseballNumber(1);
		BaseballNumber otherBaseballNumber = new BaseballNumber(1);

		assertThat(baseballNumber).isEqualTo(otherBaseballNumber);
		assertThat(baseballNumber.hashCode()).isSameAs(otherBaseballNumber.hashCode());
	}

}

package baseballnumber;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

	@Test
	@DisplayName("입력값이 세 자리가 아니면 isValid 는 false 를 리턴하여야 한다")
	void isValidShouldBeFalseIfSizeOfDigitNumbersIsNot3() {
		// given
		BaseballNumber input = new BaseballNumber(12);

		// when
		boolean result = input.isValid();

		// then
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("입력값의 각 자리수에 중복되는 값이 있으면, isValid 는 false 를 리턴하여야 한다")
	void isValidShouldBeFalseIfElementOfDigitNumbersIsDuplicated() {
		// given
		BaseballNumber input = new BaseballNumber(122);

		// when
		boolean result = input.isValid();

		// then
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("정상적인 입력값의 경우 true 를 리턴하여야 한다")
	void isValidShouldBeTrue() {
		// given
		BaseballNumber input = new BaseballNumber(123);

		// when
		boolean result = input.isValid();

		// then
		assertThat(result).isTrue();
	}
}

package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.constant.MessageContainer;
import baseball.exception.BaseballException;
import baseball.exception.InvalidNumberException;

public class GuessBaseballNumberTest {
	@Test
	@DisplayName("직접 입력한 숫자로 Baseball 생성 테스트")
	public void createBaseballNumber() {
		Integer[] numbers = new Integer[] {1, 2, 3};
		GuessBaseballNumber customNumbers = new GuessBaseballNumber(numbers);

		assertThat(customNumbers.getNumbers())
			.hasSize(numbers.length)
			.contains(numbers);

		Integer[] longNumbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		GuessBaseballNumber longCustomNumbers = new GuessBaseballNumber(longNumbers);

		assertThat(longCustomNumbers.getNumbers())
			.hasSize(longNumbers.length)
			.contains(longNumbers);
	}

	@Test
	@DisplayName("입력한 숫자가 숫자 범위를 초과했을 경우 테스트")
	public void createBaseballWithExceedNumberRange() {
		Integer[] numbers = new Integer[] {10, 1, 6, 7};

		assertThatThrownBy(() -> new GuessBaseballNumber(numbers))
			.isInstanceOf(InvalidNumberException.class)
			.hasMessage(String.format(MessageContainer.INPUT_RANGE_ERROR_MESSAGE,
				GuessBaseballNumber.BALL_MIN_VALUE, GuessBaseballNumber.BALL_MAX_VALUE));
	}

	@Test
	@DisplayName("입력한 숫자가 중복숫자를 포함할 경우 테스트")
	public void createBaseballWithDuplicate() {
		Integer[] numbers = new Integer[] {1, 1, 6, 7};

		assertThatThrownBy(() -> new GuessBaseballNumber(numbers))
			.isInstanceOf(InvalidNumberException.class)
			.hasMessage(MessageContainer.INPUT_DUPLICATE_ERROR_MESSAGE);
	}

	@Test
	@DisplayName("스트링 입력이 숫자가 아닌경우 테스트")
	public void notNumberFromInput() {
		String input = "123A";

		assertThatThrownBy(() -> new GuessBaseballNumber(input, input.length()))
			.isInstanceOf(BaseballException.class)
			.hasMessage(MessageContainer.INPUT_TYPE_ERROR_MESSAGE);
	}

	@Test
	@DisplayName("스트링 입력이 타겟숫자 길이와 맞지않는 경우 테스트")
	public void differentInputLengthWithTargetLength() {
		Integer[] targetNumbers = new Integer[] {1, 2, 3};
		String input = "1423";

		assertThatThrownBy(() -> new GuessBaseballNumber(input, targetNumbers.length))
			.isInstanceOf(BaseballException.class)
			.hasMessage(String.format(MessageContainer.INPUT_COUNT_ERROR_MESSAGE,
				targetNumbers.length, input.length()));
	}

	@Test
	@DisplayName("스트링 입력이 중복숫자를 포함한 경우 테스트")
	public void inputHasDuplicate() {
		Integer[] targetNumbers = new Integer[] {1, 2, 3};
		String input = "111";

		assertThatThrownBy(() -> new GuessBaseballNumber(input, targetNumbers.length))
			.isInstanceOf(BaseballException.class)
			.hasMessage(String.format(MessageContainer.INPUT_DUPLICATE_ERROR_MESSAGE));
	}

}

package number;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersTest {

	@DisplayName("숫자가 3자리이어야 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"12", "1234"})
	public void createNumberLengthTest(String input) {
		assertThatExceptionOfType(IllegalNumberException.class)
			.isThrownBy(() -> Numbers.of(input))
			.withMessage(IllegalNumberException.ILLEGAL_LENGTH_OF_NUMBERS.getMessage());
	}

	@DisplayName("숫자는 중복이 없어야 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"122", "133"})
	public void createNumberDuplicationTest(String input) {
		assertThatExceptionOfType(IllegalNumberException.class)
			.isThrownBy(() -> Numbers.of(input))
			.withMessage(IllegalNumberException.DUPLICATION_OF_NUMBERS.getMessage());
	}


	@DisplayName("숫자에 1~9 범위가 아닌 숫자가 포함되면 예외가 발생해야한다.")
	@ParameterizedTest
	@ValueSource(strings = {"302", "q23", "#@$"})
	public void createNumberRangeTest(String input) {
		assertThatExceptionOfType(IllegalNumberException.class)
			.isThrownBy(() -> Numbers.of(input))
			.withMessage(IllegalNumberException.ILLEGAL_RANGE_OF_NUMBER.getMessage());
	}
}

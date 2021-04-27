package number;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

	@ParameterizedTest
	@CsvSource(value = {"123:123", "124:124"}, delimiter = ':')
	@DisplayName("Numbers 의 값이 같으면 동일하다")
	public void equalTest(String myNumber, String yourNumber) {
		// given
		Numbers myNumbers = Numbers.of(myNumber);
		Numbers yourNumbers = Numbers.of(yourNumber);

		// when
		// then
		assertThat(myNumbers).isEqualTo(yourNumbers);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:124", "124:125"}, delimiter = ':')
	@DisplayName("Numbers 의 값이 다르면 동일하지 않다.")
	public void notEqualTest(String myNumber, String yourNumber) {
		// given
		Numbers myNumbers = Numbers.of(myNumber);
		Numbers yourNumbers = Numbers.of(yourNumber);

		// when
		// then
		assertThat(myNumbers).isNotEqualTo(yourNumbers);
	}

	@Test
	@DisplayName("Numbers 값이 같으면 해시값도 같다")
	public void hashCodeTest() {
		// given
		Set<Numbers> numberSet = new HashSet<>();
		Numbers myNumbers = Numbers.of("123");
		Numbers yourNumbers = Numbers.of("123");

		// when
		numberSet.add(myNumbers);
		numberSet.add(yourNumbers);

		// then
		assertThat(numberSet.size()).isEqualTo(1);
	}
}

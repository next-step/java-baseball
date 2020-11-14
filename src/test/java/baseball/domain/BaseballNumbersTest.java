package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.exception.DuplicateNumberInputException;
import baseball.domain.exception.NumbersLengthException;

class BaseballNumbersTest {

	@ParameterizedTest
	@CsvSource(value = {
		"1:2:3",
		"0:3:5",
		"8:9:3"
	}, delimiter = ':')
	@DisplayName("중복되지 않은 3자리수가 입력되면 정상 생성된다.")
	void generateNumbers(int first, int second, int third) {
		final BaseballNumbers baseballNumbers =
			BaseballNumbers.of(Arrays.asList(first, second, third));

		assertThat(baseballNumbers).isInstanceOf(BaseballNumbers.class);
		assertThat(baseballNumbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"3:2:3",
		"0:0:5",
		"4:4:4"
	}, delimiter = ':')
	@DisplayName("중복된 숫자 입력시 예외가 발생한다.")
	void duplicate_exception(int first, int second, int third) {
		assertThatThrownBy(() -> BaseballNumbers.of(Arrays.asList(first, second, third)))
			.isInstanceOf(DuplicateNumberInputException.class)
			.hasMessage("중복된 숫자가 입력될 수 없습니다.");
	}

	@Test
	@DisplayName("입력된 숫자가 세자리수가 아니면 예외가 발생한다.")
	void parameter_length_exception() {
		assertThatThrownBy(() -> BaseballNumbers.of(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage("3 자리수 숫자로만 생성할 수 있습니다.");

		assertThatThrownBy(() -> BaseballNumbers.of(Collections.singletonList(0)))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage("3 자리수 숫자로만 생성할 수 있습니다.");

		assertThatThrownBy(() -> BaseballNumbers.of(Arrays.asList(1, 2)))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage("3 자리수 숫자로만 생성할 수 있습니다.");

		assertThatThrownBy(() -> BaseballNumbers.of(Collections.emptyList()))
			.isInstanceOf(NumbersLengthException.class)
			.hasMessage("3 자리수 숫자로만 생성할 수 있습니다.");
	}
}
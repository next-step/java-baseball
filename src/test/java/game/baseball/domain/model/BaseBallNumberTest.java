package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import game.baseball.domain.shared.Message;
import game.baseball.domain.shared.NumberUtils;

class BaseBallNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {345, 123, 678})
	void constructor_success(int number) {
		assertThat(new BaseBallNumber(NumberUtils.split(number)))
			.isNotNull()
			.isInstanceOf(BaseBallNumber.class);
	}

	@Test
	@DisplayName("null일 경우 validateNull()에 의해 exception 발생")
	void validateNull_ThrowIllegalArgumentExceptionByNull() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseBallNumber(null))
			.withMessage(Message.REQUIRE_NOT_NULL);
	}

	@ParameterizedTest
	@ValueSource(ints = {12, 3456, 12345, 456789})
	void validateSize_ThrowIllegalArgumentExceptionBySize(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseBallNumber(NumberUtils.split(number)))
			.withMessage(Message.REQUIRE_THREE_DIGIT);
	}

	@ParameterizedTest
	@ValueSource(ints = {112, 121, 211, 111})
	void validateDuplication_ThrowIllegalArgumentExceptionByDuplication(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseBallNumber(NumberUtils.split(number)))
			.withMessage(Message.REQUIRE_DIFFERENT_NUMBER);
	}

	@ParameterizedTest
	@ValueSource(ints = {102, 590})
	void validateRange_ThrowIllegalArgumentExceptionByRange(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseBallNumber(NumberUtils.split(number)))
			.withMessage(Message.REQUIRE_ONE_TO_NINE);
	}

	@ParameterizedTest
	@CsvSource({"4,5,9", "6,2,1"})
	void getTest(int first, int second, int third) {
		BaseBallNumber baseBallNumber = new BaseBallNumber(Arrays.asList(first, second, third));

		assertThat(baseBallNumber.get(0)).isEqualTo(first);
		assertThat(baseBallNumber.get(1)).isEqualTo(second);
		assertThat(baseBallNumber.get(2)).isEqualTo(third);
	}

	@ParameterizedTest
	@CsvSource({"4,5,9", "6,2,1"})
	void getNumberTest(int first, int second, int third) {
		BaseBallNumber baseBallNumber = new BaseBallNumber(Arrays.asList(first, second, third));

		assertThat(baseBallNumber.getNumber()).isEqualTo(first * 100 + second * 10 + third);
	}
}

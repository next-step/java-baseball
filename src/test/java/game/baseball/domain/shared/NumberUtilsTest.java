package game.baseball.domain.shared;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import game.baseball.domain.model.BaseBallNumber;

class NumberUtilsTest {

	@ParameterizedTest
	@CsvSource({"345,3,4,5", "694,6,9,4", "146,1,4,6"})
	void splitTest(int number, int split1, int split2, int split3) {
		assertThat(NumberUtils.split(number))
			.containsExactly(split1, split2, split3);
	}

	@ParameterizedTest
	@CsvSource({"345,3,4,5", "694,6,9,4", "146,1,4,6"})
	void combineTest(int number, int split1, int split2, int split3) {
		assertThat(NumberUtils.combine(Arrays.asList(split1, split2, split3)))
			.isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = 4567)
	@DisplayName("유일한 숫자로 이루어진 숫자 전달시 정상 동작 한다.")
	void createNumberIndexMap_ReturnCorrectNumberIndexMap(int number) {
		List<Integer> numbers = NumberUtils.split(number);
		Map<Integer, Integer> numberIndexMap = NumberUtils.createNumberIndexMap(numbers);

		for (int i = 0; i < BaseBallNumber.NUMBERS_SIZE; i++) {
			assertThat(numberIndexMap.get(numbers.get(i)))
				.isEqualTo(i);
		}
	}

	@ParameterizedTest
	@ValueSource(ints = 4467)
	void createNumberIndexMap_ThrowIllegalArgumentExceptionByDuplication(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				List<Integer> numbers = NumberUtils.split(number);
				NumberUtils.createNumberIndexMap(numbers);
			})
			.withMessage(Message.REQUIRE_DIFFERENT_NUMBER);
	}
}

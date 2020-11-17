package game.baseball.domain.shared;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import game.baseball.domain.model.BaseBallNumber;

class NumberUtilsTest {

	@TestFactory
	Stream<DynamicTest> splitTest() {
		List<Integer> inputList = Arrays.asList(345, 694, 1467, 8);
		List<List<Integer>> outputList = Arrays.asList(
			Arrays.asList(3, 4, 5), Arrays.asList(6, 9, 4), Arrays.asList(1, 4, 6, 7), Collections.singletonList(8)
		);

		Iterator<Integer> inputGenerator = inputList.listIterator();
		ThrowingConsumer<Integer> testExecutor = (input) -> {
			int id = inputList.indexOf(input);

			assertThat(NumberUtils.split(input))
				.isEqualTo(outputList.get(id));
		};

		return DynamicTest.stream(
			inputGenerator,
			(input) -> "Splitting: " + input,
			testExecutor
		);
	}

	@TestFactory
	Stream<DynamicTest> combineTest() {
		List<List<Integer>> inputList = Arrays.asList(
			Arrays.asList(3, 4, 5), Arrays.asList(6, 9, 4), Arrays.asList(1, 4, 6, 7), Collections.singletonList(8)
		);
		List<Integer> outputList = Arrays.asList(345, 694, 1467, 8);

		Iterator<List<Integer>> inputGenerator = inputList.listIterator();
		ThrowingConsumer<List<Integer>> testExecutor = (input) -> {
			int id = inputList.indexOf(input);

			assertThat(NumberUtils.combine(input))
				.isEqualTo(outputList.get(id));
		};

		return DynamicTest.stream(
			inputGenerator,
			(input) -> "Combining: " + input,
			testExecutor
		);
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
	void createNumberIndexMap_ThrowIllegalArgumentExceptionBecauseDuplication(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				List<Integer> numbers = NumberUtils.split(number);
				NumberUtils.createNumberIndexMap(numbers);
			})
			.withMessage("중복된 숫자가 포함된 숫자 리스트입니다.");
	}
}

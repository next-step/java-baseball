package game.baseball.domain.shared;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

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
}

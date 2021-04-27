package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGameNumbersGeneratorTest {
	@Test
	@DisplayName("generateUniqueNumbers: should return unique numbers")
	void generateUniqueNumbers_Should_generateUniqueNumbers() {
		int[] result = NumberBaseballGameNumbersGenerator.generateUniqueNumbers(3);

		assertThat(result.length).isEqualTo(3);

		Set<Integer> numbers = new HashSet<>();
		for (int number : result) {
			numbers.add(number);
		}
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest(name = "{index} => exclusionSet={0}")
	@DisplayName("generateNewUniqueNumber: should return unique number except for input set")
	@MethodSource("generateNewUniqueNumber_Should_ReturnUniqueNumberExceptForInputSet_Params")
	void generateNewUniqueNumber_Should_ReturnUniqueNumberExceptForInputSet(Set<Integer> exclusionSet)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		NumberBaseballGameNumbersGenerator numbersGenerator = new NumberBaseballGameNumbersGenerator();
		Method method = numbersGenerator.getClass().getDeclaredMethod("generateNewUniqueNumber", Set.class);
		method.setAccessible(true);

		int result = (int) method.invoke(numbersGenerator, exclusionSet);
		assertThat(exclusionSet.contains(result)).isFalse();
	}

	private static Object[] generateNewUniqueNumber_Should_ReturnUniqueNumberExceptForInputSet_Params() {
		return new Object[] {
				generateNewUniqueNumber_Should_ReturnUniqueNumberExceptForInputSet_Param(
						new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }),
				generateNewUniqueNumber_Should_ReturnUniqueNumberExceptForInputSet_Param(
						new int[] { 2, 3, 4, 5, 6, 7, 8, 9 }) };
	}

	private static Object[] generateNewUniqueNumber_Should_ReturnUniqueNumberExceptForInputSet_Param(int[] numbers) {
		Set<Integer> expected = new HashSet<>();
		Integer[] expectedNumbers = new Integer[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			expectedNumbers[i] = numbers[i];
		}

		expected.addAll(new ArrayList<Integer>(Arrays.asList(expectedNumbers)));

		return new Object[] { expected };
	}
}

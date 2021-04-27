package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGameTypeConverterTest {
	@ParameterizedTest(name = "{index} => target={0}, expected={1}")
	@DisplayName("convertStringToIntArray: should convert string to int array")
	@MethodSource("convertStringToIntArray_Should_ConvertStringToIntArray_Params")
	void convertStringToIntArray_Should_ConvertStringToIntArray(String target, int[] expected) {
		int[] result = NumberBaseballGameTypeConverter.convertStringToIntArray(target);
		assertThat(result).isEqualTo(expected);
	}

	private static Object[] convertStringToIntArray_Should_ConvertStringToIntArray_Params() {
		return new Object[] {
			new Object[] {"139", new int[] {1, 3, 9}},
			new Object[] {"456", new int[] {4, 5, 6}},
			new Object[] {"719", new int[] {7, 1, 9}}
		};
	}

	@ParameterizedTest(name = "{index} => target={0}, expected={1}")
	@DisplayName("convertIntArrayToSet: should convert int array to set")
	@MethodSource("convertIntArrayToSet_Should_ConvertIntArrayToSet_Params")
	void convertIntArrayToSet_Should_ConvertIntArrayToSet(int[] target, Set<Integer> expected) {
		Set<Integer> result = NumberBaseballGameTypeConverter.convertIntArrayToSet(target);
		assertThat(result).isEqualTo(expected);
	}

	private static Object[] convertIntArrayToSet_Should_ConvertIntArrayToSet_Params() {
		return new Object[] {
			convertIntArrayToSet_Should_ConvertIntArrayToSet_Param(new int[] {1, 3, 9}),
			convertIntArrayToSet_Should_ConvertIntArrayToSet_Param(new int[] {4, 5, 6})
		};
	}

	private static Object[] convertIntArrayToSet_Should_ConvertIntArrayToSet_Param(int[] numbers) {
		Set<Integer> expected = new HashSet<>();
		Integer[] expectedNumbers = new Integer[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			expectedNumbers[i] = numbers[i];
		}

		expected.addAll(new ArrayList<Integer>(Arrays.asList(expectedNumbers)));

		return new Object[] {numbers, expected};
	}
}

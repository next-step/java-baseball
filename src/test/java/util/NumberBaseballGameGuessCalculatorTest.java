package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NumberBaseballGameGuessCalculatorTest {
	@ParameterizedTest(name = "{index} => targetNumbers={0}, userInput={1}, expected={2}")
	@DisplayName("calculateStrikeCount: should return strike count")
	@MethodSource("calculateStrikeCount_Should_ReturnStrikeCount_Params")
	void calculateStrikeCount_Should_ReturnStrikeCount(int[] targetNumbers, int[] userInput, int expected) {
		int result = NumberBaseballGameGuessCalculator.calculateStrikeCount(targetNumbers, userInput);
		assertThat(result).isEqualTo(expected);
	}

	private static Object[] calculateStrikeCount_Should_ReturnStrikeCount_Params() {
		return new Object[] {
			new Object[] {new int[] {1, 3, 9}, new int[] {1, 3, 9}, 3},
			new Object[] {new int[] {1, 2, 3}, new int[] {4, 5, 6}, 0},
			new Object[] {new int[] {9, 8, 7}, new int[] {7, 9, 8}, 0},
			new Object[] {new int[] {9, 8, 7}, new int[] {6, 9, 7}, 1},
			new Object[] {new int[] {1, 2, 1}, new int[] {7, 1, 9}, 0}
		};
	}

	@ParameterizedTest(name = "{index} => targetNumbers={0}, userInput={1}, expected={2}")
	@DisplayName("calculateBallCount: should return ball count")
	@MethodSource("calculateBallCount_Should_ReturnBallCount_Params")
	void calculateBallCount_Should_ReturnBallCount(int[] targetNumbers, int[] userInput, int expected) {
		int result = NumberBaseballGameGuessCalculator.calculateBallCount(targetNumbers, userInput);
		assertThat(result).isEqualTo(expected);
	}

	private static Object[] calculateBallCount_Should_ReturnBallCount_Params() {
		return new Object[] {
			new Object[] {new int[] {1, 3, 9}, new int[] {1, 3, 9}, 0},
			new Object[] {new int[] {1, 2, 3}, new int[] {2, 3, 1}, 3},
			new Object[] {new int[] {9, 8, 7}, new int[] {8, 9, 7}, 2},
			new Object[] {new int[] {9, 8, 7}, new int[] {6, 4, 2}, 0},
			new Object[] {new int[] {7, 1, 9}, new int[] {1, 2, 1}, 2},
			new Object[] {new int[] {7, 1, 9}, new int[] {1, 1, 1}, 2}
		};
	}

	@ParameterizedTest(name = "{index} => targetNumbers={0}, inputNumber={1}, index={2}, expected={3}")
	@DisplayName("isStrike: should return if input number is strike")
	@MethodSource("isStrike_Should_ReturnIfInputNumberIsStrike_Params")
	void isStrike_Should_ReturnIfInputNumberIsStrike(int[] targetNumbers, int inputNumber, int index, boolean expected)
		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
		InvocationTargetException {
		NumberBaseballGameGuessCalculator guessCalculator = new NumberBaseballGameGuessCalculator();
		Method method = guessCalculator.getClass().getDeclaredMethod("isStrike", int[].class, int.class, int.class);
		method.setAccessible(true);

		boolean result = (boolean)method.invoke(guessCalculator, targetNumbers, inputNumber, index);
		assertThat(result).isEqualTo(expected);
	}

	private static Object[] isStrike_Should_ReturnIfInputNumberIsStrike_Params() {
		return new Object[] {
			new Object[] {new int[] {1, 3, 9}, 1, 0, true},
			new Object[] {new int[] {8, 2, 3}, 2, 1, true},
			new Object[] {new int[] {6, 5, 4}, 4, 2, true},
			new Object[] {new int[] {1, 2, 3}, 3, 0, false},
			new Object[] {new int[] {1, 2, 3}, 3, 1, false}
		};
	}

	@ParameterizedTest(name = "{index} => targetNumbers={0}, inputNumber={1}, index={2}, expected={3}")
	@DisplayName("isBall: should return if input number is ball")
	@MethodSource("isBall_Should_ReturnIfInputNumberIsBall_Params")
	void isBall_Should_ReturnIfInputNumberIsBall(int[] targetNumbers, int inputNumber, int index, boolean expected)
		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
		InvocationTargetException {
		NumberBaseballGameGuessCalculator guessCalculator = new NumberBaseballGameGuessCalculator();
		Method method = guessCalculator.getClass().getDeclaredMethod("isBall", int[].class, int.class, int.class);
		method.setAccessible(true);

		boolean result = (boolean)method.invoke(guessCalculator, targetNumbers, inputNumber, index);
		assertThat(result).isEqualTo(expected);
	}

	private static Object[] isBall_Should_ReturnIfInputNumberIsBall_Params() {
		return new Object[] {
			new Object[] {new int[] {7, 1, 9}, 7, 0, false},
			new Object[] {new int[] {8, 2, 3}, 2, 1, false},
			new Object[] {new int[] {6, 5, 4}, 4, 2, false},
			new Object[] {new int[] {1, 2, 3}, 3, 0, true},
			new Object[] {new int[] {1, 2, 3}, 2, 2, true},
			new Object[] {new int[] {1, 2, 3}, 1, 1, true}
		};
	}
}

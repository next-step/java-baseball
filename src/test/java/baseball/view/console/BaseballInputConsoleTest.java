package baseball.view.console;

import baseball.controller.dto.EndGameRequest;
import baseball.controller.dto.GuessNumberRequest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static baseball.controller.dto.EndGameRequest.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballInputConsoleTest {

	private Method getIsValidGuessNumberMethod(BaseballInputConsole testClass) throws NoSuchMethodException {
		Method method = testClass.getClass().getDeclaredMethod("isValidGuessNumber", String.class);
		method.setAccessible(true);
		return method;
	}

	@Test
	void isValidGuessNumberTest() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getIsValidGuessNumberMethod(testClass);

		String testInput = "123";

		try {
			assertTrue((Boolean) method.invoke(testClass, testInput));
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	void isValidGuessNumberTestFailLength() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getIsValidGuessNumberMethod(testClass);

		String testInput = "1";

		try {
			assertFalse((Boolean) method.invoke(testClass, testInput));
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	void isValidGuessNumberTestFailNumeric() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getIsValidGuessNumberMethod(testClass);

		String testInput = "abc";

		try {
			assertFalse((Boolean) method.invoke(testClass, testInput));
		} catch (Exception e) {
			assert(false);
		}
	}

	private Method getConvertToGuessNumberRequestMethod(BaseballInputConsole testClass) throws NoSuchMethodException {
		Method method = testClass.getClass().getDeclaredMethod("convertToGuessNumberRequest", String.class);
		method.setAccessible(true);
		return method;
	}
	@Test
	void convertToGuessNumberRequestTest() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getConvertToGuessNumberRequestMethod(testClass);

		String testInput = "123";
		List<Integer> expectedResult = Arrays.asList(1, 2, 3);

		try {
			GuessNumberRequest actualResult = ((GuessNumberRequest) method.invoke(testClass, testInput));
			assertEquals(expectedResult, actualResult.getGuessNumbers());
		} catch (Exception e) {
			assert(false);
		}
	}

	private Method getIsValidEndGameActionMethod(BaseballInputConsole testClass) throws NoSuchMethodException {
		Method method = testClass.getClass().getDeclaredMethod("isValidEndGameAction", String.class);
		method.setAccessible(true);
		return method;
	}

	@Test
	void isValidEndGameActionTest() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getIsValidEndGameActionMethod(testClass);

		String testInput = "1";

		try {
			assertTrue((Boolean) method.invoke(testClass, testInput));
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	void isValidEndGameActionTestFailLength() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getIsValidEndGameActionMethod(testClass);

		String testInput = "12";

		try {
			assertFalse((Boolean) method.invoke(testClass, testInput));
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	void isValidEndGameActionTestFailAction() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getIsValidEndGameActionMethod(testClass);

		String testInput = "3";

		try {
			assertFalse((Boolean) method.invoke(testClass, testInput));
		} catch (Exception e) {
			assert(false);
		}
	}

	private Method getConvertToEndGameRequestMethod(BaseballInputConsole testClass) throws NoSuchMethodException {
		Method method = testClass.getClass().getDeclaredMethod("convertToEndGameRequest", String.class);
		method.setAccessible(true);
		return method;
	}

	@Test
	void convertToEndGameRequestTestRestart() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getConvertToEndGameRequestMethod(testClass);

		String testInput = "1";
		Action expectedResult = Action.RESTART;

		try {
			EndGameRequest actualResult = (EndGameRequest) method.invoke(testClass, testInput);
			assertEquals(expectedResult, actualResult.getAction());
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	void convertToEndGameRequestTestEnd() throws NoSuchMethodException {
		BaseballInputConsole testClass = new BaseballInputConsole();
		Method method = getConvertToEndGameRequestMethod(testClass);

		String testInput = "2";
		Action expectedResult = Action.END;

		try {
			EndGameRequest actualResult = (EndGameRequest) method.invoke(testClass, testInput);
			assertEquals(expectedResult, actualResult.getAction());
		} catch (Exception e) {
			assert(false);
		}
	}
}
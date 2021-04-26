package ui;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameplayUITest {

	private static GameplayUI gameplayUI;
	private static Method hasSameNumber;
	private static Method isValidNumberFormat;

	@BeforeAll
	public static void beforeAll() throws NoSuchMethodException {
		gameplayUI = new GameplayUI();

		hasSameNumber = GameplayUI.class.getDeclaredMethod("hasSameNumber", String.class);
		hasSameNumber.setAccessible(true);

		isValidNumberFormat = GameplayUI.class.getDeclaredMethod("isValidNumberFormat", String.class);
		isValidNumberFormat.setAccessible(true);
	}

	@ParameterizedTest
	@ValueSource(strings = {"332", "155", "494", "777"})
	void hasSameNumber_SameDigitNumbers_True(String input) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)hasSameNumber.invoke(gameplayUI, input);
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"312", "985", "531", "786"})
	void isValidNumberFormat_ValidNumbers_True(String input) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isValidNumberFormat.invoke(gameplayUI, input);
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"3", "91", "5314", "786945"})
	void isValidNumberFormat_InvalidLength_False(String input) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isValidNumberFormat.invoke(gameplayUI, input);
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"301", "910", "012"})
	void isValidNumberFormat_InputsWithZero_False(String input) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isValidNumberFormat.invoke(gameplayUI, input);
		assertThat(result).isFalse();
	}

}

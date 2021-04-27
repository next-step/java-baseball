package ui;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuUITest {

	private static MenuUI menuUI;
	private static Method getMenuInput;

	@BeforeAll
	public static void beforeAll() throws NoSuchMethodException {
		menuUI = new MenuUI();
		setReflectionForMethod();
	}

	private static void setReflectionForMethod() throws NoSuchMethodException {
		getMenuInput = MenuUI.class.getDeclaredMethod("getMenuInput", String.class);
		getMenuInput.setAccessible(true);
	}

	@Test
	void getMenuInput_EnterTwo_False()
		throws InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)getMenuInput.invoke(menuUI, "2");
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"3", "5", "a", "%"})
	void getMenuInput_InvalidInputs_True(String input)
		throws InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)getMenuInput.invoke(menuUI, input);
		assertThat(result).isTrue();
	}
}

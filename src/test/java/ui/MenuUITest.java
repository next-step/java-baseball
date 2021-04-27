package ui;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuUITest {

	private static MenuUI menuUI;

	@BeforeAll
	public static void beforeAll() {
		menuUI = new MenuUI();
	}

	@Test
	void getMenuInput_EnterTwo_False() {
		assertThat(menuUI.getMenuInput("2")).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"3", "5", "a", "%"})
	void getMenuInput_InvalidInputs_True(String input) {
		assertThat(menuUI.getMenuInput(input)).isTrue();
	}
}

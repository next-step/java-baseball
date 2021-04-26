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

	@ParameterizedTest
	@ValueSource(strings = {"3", "5", "a", "%"})
	void isValidMenuInput_InvalidInputs_False(String input) {
		assertThat(menuUI.isValidMenuInput(input)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	void isValidMenuInput_ValidInputs_True(String input) {
		assertThat(menuUI.isValidMenuInput(input)).isTrue();
	}

	@Test
	void getMenuInput_EnterOne_True() {
		assertThat(menuUI.getMenuInput("1")).isTrue();
	}

	@Test
	void isValidMenuInput_EnterTwo_False() {
		assertThat(menuUI.getMenuInput("2")).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"3", "5", "a", "%"})
	void isValidMenuInput_InvalidInputs_True(String input) {
		assertThat(menuUI.getMenuInput(input)).isTrue();
	}
}

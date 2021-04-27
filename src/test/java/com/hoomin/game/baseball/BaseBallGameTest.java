package com.hoomin.game.baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.hoomin.game.baseball.enums.GameOption;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseBallGameTest {

	private BaseBallGame baseBallGame;

	@BeforeAll
	public void beforeAll() {
		baseBallGame = new BaseBallGame();
	}

	@ParameterizedTest
	@EnumSource(value = GameOption.class, names = {"RESTART"})
	public void isOnGoing_RevivedRESTART_ReturnTrue(GameOption gameOption) {
		assertTrue(baseBallGame.isOnGoing(gameOption));
	}

	@ParameterizedTest
	@EnumSource(value = GameOption.class, names = {"QUIT"})
	public void isOnGoing_RevivedQUIT_ReturnFalse(GameOption gameOption) {
		assertFalse(baseBallGame.isOnGoing(gameOption));
	}

	@ParameterizedTest
	@ValueSource(strings = {"TEST"})
	public void isOnGoing_InvalidInput_IllegalArgumentExceptionThrown(String input) {
		assertThatThrownBy(() -> GameOption.valueOf(input).isOnGoing())
			.isInstanceOf(IllegalArgumentException.class);
	}
}

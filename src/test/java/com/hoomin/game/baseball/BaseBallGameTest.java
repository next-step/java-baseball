package com.hoomin.game.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseBallGameTest {
	private BaseBallGame baseBallGame;

	@BeforeAll
	public void beforeAll() {
		baseBallGame = new BaseBallGame();
	}

	@ParameterizedTest
	@ValueSource(ints = {1})
	public void isOnGoing_InputGameOption_RetunTrue(int input) {
		assertTrue(baseBallGame.isOnGoing(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {2})
	public void isOnGoing_InputGameOption_RetunFalse(int input) {
		assertFalse(baseBallGame.isOnGoing(input));
	}
}

package com.hoomin.game.baseball;

import static org.assertj.core.api.Assertions.*;
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
	public void isOnGoing_InputGameOption_ReturnTrue(int input) {
		assertTrue(baseBallGame.isOnGoing(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {2})
	public void isOnGoing_InputGameOption_ReturnFalse(int input) {
		assertFalse(baseBallGame.isOnGoing(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {3, -1})
	public void isOnGoing_InputGameOption_IllegalArgumentExceptionThrown(int input) {
		assertThatThrownBy(() -> baseBallGame.isOnGoing(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1또는 2를 입력해야 합니다.");
	}
}

package com.pointware.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.pointware.game.validation.GameNumberValidationResult;
import com.pointware.game.validation.GameNumberValidator;

class GameNumberValidatorTest {

	private GameNumberValidator gameNumberValidator = new GameNumberValidator();

	@ParameterizedTest
	@CsvSource(value = {
		"123:123:3:0",
		"123:312:0:3",
		"123:321:1:2",
		"123:456:0:0"
	}, delimiter = ':')
	void validate_strike_ball_count(int target, int source, int strikeCount, int ballCount) {
		GameNumberValidationResult result = gameNumberValidator.validate(target, source);
		assertEquals(strikeCount, result.getStrikeCount());
		assertEquals(ballCount, result.getBallCount());
	}
}

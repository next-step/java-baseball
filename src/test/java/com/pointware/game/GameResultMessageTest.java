package com.pointware.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.pointware.game.validation.GameNumberValidationResult;

class GameResultMessageTest {

	@ParameterizedTest
	@CsvSource(value = {
		"낫싱:0:0",
		"3 스트라이크:3:0",
		"1 스트라이크 2볼:1:2",
		"3볼:0:3"
	}, delimiter = ':')
	@DisplayName("게임 결과에 따라 발생되는 메시지 확인")
	void getMessage(String expectMessage, int strikeCount, int ballCount) {
		GameNumberValidationResult validationResult = new GameNumberValidationResult(strikeCount, ballCount);
		assertEquals(expectMessage, GameResultMessage.of(validationResult));
	}
}

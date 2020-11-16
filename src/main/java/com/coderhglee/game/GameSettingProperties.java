package com.coderhglee.game;

public enum GameSettingProperties {
	INPUT_MESSAGE_MAX_LENGTH(3),
	GAME_NUMBER_MIN_RANGE(1),
	GAME_NUMBER_MAX_RANGE(10),
	ADD_ONE_SCORE(1),
	ADD_ZERO_SCORE(0),
	GAME_START_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	ROUND_START_MESSAGE("숫자를 입력해주세요: ");


	public int value;
	public String message;

	GameSettingProperties(int value) {
		this.value = value;
	}

	GameSettingProperties(String message) {
		this.message = message;
	}
}

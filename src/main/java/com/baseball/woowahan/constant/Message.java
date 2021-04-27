package com.baseball.woowahan.constant;

import org.apache.commons.lang3.StringUtils;

import com.baseball.woowahan.Game;

public enum Message {
	INPUT("숫자를 입력하세요 : "),
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("나싱"),
	NULL_INPUT("입력 값이 없습니다."),
	INVALID_INPUT(StringUtils.join("서로 다른 1~9 숫자 ", Game.gameLength, "개만 입력 가능합니다.")),
	INVALID_RESTART("1또는 2만 입력 가능합니다."),
	RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	COMPLETE(StringUtils.join(Game.gameLength, "개의 숫자를 모두 맞히였습니다! 게임종료"));

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

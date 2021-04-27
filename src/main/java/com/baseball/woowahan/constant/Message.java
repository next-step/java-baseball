package com.baseball.woowahan.constant;

public enum Message {
	INPUT("중복되지 않은 1~9 숫자를 3개 입력 하세요. (ex. 135)"),
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("나싱"),
	NULL_INPUT("입력 값이 없습니다."),
	INVALID_INPUT("서로 다른 1~9 숫자 3개만 입력 가능합니다."),
	INVALID_RESTART("1또는 2만 입력 가능합니다."),
	RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	COMPLETE("3개의 숫자를 모두 맞히였습니다! 게임종료");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

package com.baseball.woowahan;

public enum Message {
	INPUT("== 중복되지 않은 1~9 숫자를 3개 입력 하세요. (ex. 135) =="),
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("나싱"),
	INVALID("올바른 입력 값이 아닙니다."),
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

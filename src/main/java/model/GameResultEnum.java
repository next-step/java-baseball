package model;

public enum GameResultEnum {
	STRIKE(" 스트라이크"),
	BALL(" 볼"),
	NOTHING("낫싱"),
	DONE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	String message;

	GameResultEnum(String message) {
		this.message = message;
	}

	public String getMessage(int count) {
		return (count == 0) ? "" : count + message;
	}

	public String getValue() {
		return this.message;
	}
}

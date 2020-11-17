package io.github.sejoung.baseball.constants;

public enum GameMessage {

	INPUT("숫자를 입력해주세요: "), SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임종료"), RESTART("게임을 새로 시작 하려면 1,종료 하려면 2를 입력하세요.");

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

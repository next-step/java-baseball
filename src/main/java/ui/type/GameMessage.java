package ui.type;

public enum GameMessage {

	INPUT_DATA("숫자를 입력해주세요 : "),
	INPUT_RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	OUTPUT_STRIKE("스트라이크"),
	OUTPUT_BALL("볼"),
	OUTPUT_NOTHING("낫싱"),
	OUTPUT_GAME_CLEAR("3개의 숫자를 모두 맞추셨습니다! 게임 종료"),
	;

	private String message;

	GameMessage(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}
}

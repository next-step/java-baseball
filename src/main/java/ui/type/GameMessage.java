package ui.type;

public enum GameMessage {

	INPUT_DATA("숫자를 입력해주세요 : ");

	private String message;

	GameMessage(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}
}

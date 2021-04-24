package domain.game;

public enum GameStatus {
	ONGOING(1),
	FINISHED(2);

	private int code;

	GameStatus(int code){
		this.code = code;
	}
	public int getCode() {
		return code;
	}
}
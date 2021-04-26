package ui.type;

public enum GameCommand {
	NONE(0),
	RESTART(1),
	FINISH(2)
	;

	private int code;

	GameCommand(final int code){
		this.code = code;
	}

	public boolean isRestart(){
		return this == RESTART;
	}
}

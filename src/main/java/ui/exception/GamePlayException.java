package ui.exception;

import ui.type.GamePlayExceptionType;

public class GamePlayException extends RuntimeException{

	private GamePlayException(final String message){
		super(message);
	}

	public static GamePlayException getInstance(GamePlayExceptionType type){
		return new GamePlayException(type.getMessage());
	}
}

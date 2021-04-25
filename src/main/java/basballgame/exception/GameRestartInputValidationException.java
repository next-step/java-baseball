package basballgame.exception;

public class GameRestartInputValidationException extends ValidationException{
	public GameRestartInputValidationException() {
		super(ExceptionMessages.INVALID_GAME_RESTART_INPUT_NUMBER);
	}
}

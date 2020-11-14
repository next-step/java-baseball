package baseball.game;

public class InvalidBallNumbersException extends RuntimeException {

	private String ballNumbers;

	public InvalidBallNumbersException(String ballNumbers) {
		super("Invalid ball numbers(" + ballNumbers + ")");
		this.ballNumbers = ballNumbers;
	}

	public String getBallNumbers() {
		return this.ballNumbers;
	}
}

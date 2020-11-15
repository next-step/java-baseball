package baseball.domain;

public class Game {
	public static final int MAX_GAME_NUMBER_LENGTH = 3;
	private GameNumbers rightAnswer;
	private GameStatus status;

	public Game(GameNumberGenerator gameNumberGenerator) {
		status = GameStatus.IN_PROGRESSING;
		rightAnswer = gameNumberGenerator.generate(MAX_GAME_NUMBER_LENGTH);
	}

	public GameNumbers getRightAnswer() {
		return rightAnswer;
	}

	public GameHint play(String input) {
		GameNumbers userAnswer = GameInputConverter.convertInputToGameNumbers(input, MAX_GAME_NUMBER_LENGTH);

		if (userAnswer.equals(rightAnswer)) {
			status = GameStatus.END;
			return null;
		}

		return new GameHint(rightAnswer, userAnswer);
	}

	public boolean isFinished() {
		return status == GameStatus.END;
	}
}

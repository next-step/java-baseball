package baseball;

public class Game {
	public static int MAX_GAME_NUMBER_LENGTH = 3;
	private GameNumbers rightAnswer;

	public Game(GameNumberGenerator gameNumberGenerator) {
		rightAnswer = gameNumberGenerator.generate(MAX_GAME_NUMBER_LENGTH);
	}

	public GameNumbers getRightAnswer() {
		return rightAnswer;
	}
}

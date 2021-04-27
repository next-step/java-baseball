import baseballgame.BaseBallGame;
import baseballgame.Validator;

public class Main {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame(new Validator());
		baseBallGame.createProblemNumbers();

		while (baseBallGame.isPlaying()) {
			baseBallGame.receiveAnswerNumbers();
			baseBallGame.countStrikesAndBalls();
			baseBallGame.printCountResults();
			baseBallGame.confirmCorrectAnswer();
		}
	}
}

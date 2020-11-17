package NumberBaseballGame;

public class NumberBaseballGameMain {

	public void start() {
		boolean isRestartGame = true;

		while (isRestartGame) {
			NumberBaseballGame game = new NumberBaseballGame();

			startGame(game);

			isRestartGame = game.isRestartGame();
		}
	}

	public void startGame(NumberBaseballGame game) {
		boolean isContinueGame = true;
		int[] inputData = new int[3];
		BallCount ballCount = new BallCount();

		while (isContinueGame) {
			inputData = game.writeInputDate();
			ballCount = game.judgeBallCount(inputData);
			game.printBallCount(ballCount);
			isContinueGame = game.isEndGame(ballCount);
		}
	}

	public static void main(String[] args) {
		NumberBaseballGameMain numberBaseballGameMain = new NumberBaseballGameMain();
		numberBaseballGameMain.start();
	}
}

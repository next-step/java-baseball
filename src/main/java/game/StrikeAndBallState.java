package game;

import number.BaseballNumbers;
import ui.OutputManager;
import ui.PrintOutputManager;

public class StrikeAndBallState implements GameState {

	private final OutputManager outputManager = PrintOutputManager.getInstance();
	
	private static GameState gameState = new StrikeAndBallState();

	private StrikeAndBallState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		int strikeCount = 0;
		int ballCount = 0;

		BaseballNumbers computerBaseballNumbers = game.getComputer().getNumbers();
		BaseballNumbers userBaseballNumbers = game.getUser().getNumbers();

		for (int i = 0; i < computerBaseballNumbers.size(); i++) {
			if (computerBaseballNumbers.get(i) == userBaseballNumbers.get(i)) {
				strikeCount++;
			}
		}

		for (int i = 0; i < computerBaseballNumbers.size(); i++) {
			for (int j = 0; j < userBaseballNumbers.size(); j++) {
				if (i != j && computerBaseballNumbers.get(i) == userBaseballNumbers.get(j)) {
					ballCount++;
				}
			}
		}

		if (strikeCount + ballCount == 0) {
			game.setGameState(NothingState.getInstance());
			game.progress();

			return;
		}

		outputManager.print(strikeCount + " 스트라이크 " + ballCount + "볼" + "\n");
		game.setGameState(RunningState.getInstance());
		game.progress();
	}

}

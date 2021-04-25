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
		BaseballNumbers computerBaseballNumbers = game.getComputer().getNumbers();
		BaseballNumbers userBaseballNumbers = game.getUser().getNumbers();

		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < computerBaseballNumbers.size(); i++) {
			strikeCount += countEquals(computerBaseballNumbers.get(i), userBaseballNumbers.get(i));
			ballCount += countContains(computerBaseballNumbers, userBaseballNumbers.get(i));
		}
		ballCount -= strikeCount;

		if (strikeCount + ballCount == 0) {
			game.setGameState(NothingState.getInstance());
			game.progress();
			return;
		}

		outputManager.print(strikeCount + " 스트라이크 " + ballCount + "볼" + "\n");
		game.setGameState(RunningState.getInstance());
		game.progress();
	}

	private int countEquals(Integer computerNumber, Integer userNnumber) {
		return computerNumber.equals(userNnumber) ? 1 : 0;
	}

	private int countContains(BaseballNumbers computerBaseballNumbers, Integer userNnumber) {
		return computerBaseballNumbers.contains(userNnumber) ? 1 : 0;
	}

}

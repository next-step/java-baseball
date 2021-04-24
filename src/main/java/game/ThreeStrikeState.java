package game;

import number.BaseballNumbers;
import ui.OutputManager;
import ui.PrintOutputManager;

public class ThreeStrikeState implements GameState {

	private final OutputManager outputManager = PrintOutputManager.getInstance();
	
	private static GameState gameState = new ThreeStrikeState();

	private ThreeStrikeState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		BaseballNumbers computerBaseballNumbers = game.getComputer().getNumbers();
		BaseballNumbers userBaseballNumbers = game.getUser().getNumbers();

		if (isThreeStrike(computerBaseballNumbers, userBaseballNumbers)) {
			game.setGameState(EndState.getInstance());
			game.progress();

			return;
		}
		game.setGameState(StrikeAndBallState.getInstance());
		game.progress();
	}

	private boolean isThreeStrike(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
		boolean result = true;

		for (int i = 0; i < computerBaseballNumbers.size(); i++) {
			if (computerBaseballNumbers.get(i) != userBaseballNumbers.get(i)) {
				result = false;

				return result;
			}
		}

		if (result) {
			outputManager.print(computerBaseballNumbers.size() + " 스트라이크" + "\n");
		}

		return result;
	}
}

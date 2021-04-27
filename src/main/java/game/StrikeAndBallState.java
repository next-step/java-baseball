package game;

import number.BaseballNumbers;
import rule.Rule;
import ui.OutputManager;
import ui.PrintOutputManager;

public class StrikeAndBallState implements GameState {

	private final OutputManager outputManager = PrintOutputManager.getInstance();
	private final Rule rule = Rule.getInstance();

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

		if (rule.isNothing(computerBaseballNumbers, userBaseballNumbers)) {
			game.setGameState(NothingState.getInstance());
			game.progress();
			return;
		}

		printStrikeAndBall(rule.countStrike(computerBaseballNumbers, userBaseballNumbers),
				rule.countBall(computerBaseballNumbers, userBaseballNumbers));
		game.setGameState(RunningState.getInstance());
		game.progress();
	}

	private void printStrikeAndBall(int strikeCount, int ballCount) {
		if (strikeCount > 0) {
			outputManager.print(strikeCount + " 스트라이크 ");
		}

		if (ballCount > 0) {
			outputManager.print(ballCount + "볼");
		}

		outputManager.print("\n");
	}

}

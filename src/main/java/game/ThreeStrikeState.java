package game;

import number.BaseballNumbers;
import rule.Rule;
import ui.OutputManager;
import ui.PrintOutputManager;

public class ThreeStrikeState implements GameState {
	
	private final OutputManager outputManager = PrintOutputManager.getInstance();
	private final Rule rule = Rule.getInstance();
	
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

		if(rule.isThreeStrike(computerBaseballNumbers, userBaseballNumbers)) {
			outputManager.print(computerBaseballNumbers.size() + " 스트라이크" + "\n");
			game.setGameState(EndState.getInstance());
			game.progress();
			return;
		}
		
		game.setGameState(StrikeAndBallState.getInstance());
		game.progress();
	}
}

package game;

import ui.OutputManager;
import ui.PrintOutputManager;

public class RunningState implements GameState {

	private final OutputManager outputManager = PrintOutputManager.getInstance();

	private static GameState gameState = new RunningState();

	private RunningState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		outputManager.print("숫자를 입력해주세요 : ");
		game.getUser().generateNumbers();

		game.setGameState(ThreeStrikeState.getInstance());

		game.progress();
	}

}

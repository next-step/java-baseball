package game;

import ui.OutputManager;
import ui.PrintOutputManager;

public class NothingState implements GameState {

	private final OutputManager outputManager = PrintOutputManager.getInstance();
	
	private static GameState gameState = new NothingState();

	private NothingState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		outputManager.print("낫싱"+"\n");
		
		game.setGameState(RunningState.getInstance());
		game.progress();
	}

}

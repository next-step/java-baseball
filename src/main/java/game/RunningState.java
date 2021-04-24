package game;

public class RunningState implements GameState {

	private static GameState gameState = new RunningState();

	private RunningState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

package game;

public class ExitState implements GameState {

	private static GameState gameState = new ExitState();

	private ExitState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

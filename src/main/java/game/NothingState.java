package game;

public class NothingState implements GameState {

	private static GameState gameState = new NothingState();

	private NothingState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

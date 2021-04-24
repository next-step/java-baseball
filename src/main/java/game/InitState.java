package game;

public class InitState implements GameState {

	private static GameState gameState = new InitState();

	private InitState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

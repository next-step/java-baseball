package game;

public class InitGameState implements GameState {

	private static GameState gameState = new InitGameState();

	private InitGameState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

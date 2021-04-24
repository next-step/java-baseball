package game;

public class EndState implements GameState {

	private static GameState gameState = new EndState();

	private EndState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

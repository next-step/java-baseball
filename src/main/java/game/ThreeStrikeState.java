package game;

public class ThreeStrikeState implements GameState {

	private static GameState gameState = new ThreeStrikeState();

	private ThreeStrikeState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

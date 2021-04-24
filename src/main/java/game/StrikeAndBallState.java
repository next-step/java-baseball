package game;

public class StrikeAndBallState implements GameState {

	private static GameState gameState = new StrikeAndBallState();

	private StrikeAndBallState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {
		
	}

}

package game;

import player.Player;
import player.PlayerFactory;

public class Game {
	private final Player computer = PlayerFactory.getInstance().computer();
	private Player user;

	private GameState gameState;

	public Game(Player user) {
		this.user = user;
		this.gameState = InitState.getInstance();
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public Player getComputer() {
		return computer;
	}

	public Player getUser() {
		return user;
	}

	public void start() {
		progress();
	}

	public void progress() {
		gameState.next(this);
	}

	public void end() {
		// do nothing
	}

}

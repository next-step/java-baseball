package game;

import player.Player;

public class Game {
	private Player computer;
	private Player user;

	private GameState gameState;

	public Game(Player computer, Player user) {
		this.computer = computer;
		this.user = user;
		this.gameState = InitGameState.getInstance();
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

	public void exit() {
		//do nothing
	}

}

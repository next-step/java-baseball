package view;

import java.util.List;

import service.GameService;

public class GameView {

	private GameService gameService;

	public GameView() {
		gameService = new GameService();
	}

	public void start() {
		gameService.start();
	}
}

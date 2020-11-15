package view;

import java.util.List;

import service.GameService;

public class GameView {

	private static GameService gameService = new GameService();

	public static void start() {
		// Generate numbers
		List<Integer> balls = gameService.generate();
	}
}

public class Main {
	public static void main(String[] args) {
		Game game = Game.createGame();
		GameUtils gameUtils = new GameUtils(game);

		while(!gameUtils.isEnd()) {
			gameUtils.run();
		}
	}
}

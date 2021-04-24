public class BaseballMain {

	public static void main(String[] args) {
		BaseballConsole console = new BaseballConsole();
		BaseballGame game = new BaseballGame(console);

		game.initGame();
		game.requestInputNumbers();
	}

}

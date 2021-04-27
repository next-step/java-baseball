package baseball;

public class Main {
	public static void main(String[] args) {
		GameExitCode code;

		do {
			Game game = new Game();
			code = game.start();
		} while (code == GameExitCode.RESTART);
	}
}

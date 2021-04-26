package exam.baseball;

import java.util.function.Supplier;

public class GameLauncher {

	private static int cnt = 1;
	public static Supplier<String> mockUserCommandSupplier = () -> {
		if (cnt <= 0) {
			System.out.println("2");
			return "2";
		}
		cnt--;
		System.out.println("1");
		return "1";
	};

	public static void main(String[] args) {
		Game game = new BaseballGame(mockUserCommandSupplier);
		do {
			game.start();
		} while (game.restart());
		game.exit();
	}
}

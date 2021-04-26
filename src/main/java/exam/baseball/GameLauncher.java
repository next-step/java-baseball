package exam.baseball;

import java.util.Scanner;
import java.util.function.Supplier;

public class GameLauncher {
	private static Scanner scanner = new Scanner(System.in);
	public static Supplier<String> mockUserCommandSupplier = () -> {
		return scanner.nextLine();
	};

	public static void main(String[] args) {
		Game game = new BaseballGame(mockUserCommandSupplier);
		do {
			game.start();
		} while (game.restart());
		game.exit();
	}
}

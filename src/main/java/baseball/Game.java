package baseball;

import java.util.Scanner;

public class Game {

	private static Scanner scanner = new Scanner(System.in);
	private static Converter converter = new Converter();
	private static Referee referee = new Referee();
	private static Player player = new Player();

	private static String raw;

	public static void main(String[] args) {
		while (menu()) {
			game();
		}
	}

	// Game Logic
	public static boolean menu() {
		System.out.println("\n게임을 시작하겠습니까? (Y/n):");
		String select = scanner.nextLine();
		return !select.equals("n");
	}

	// Game Logic
	public static void game() {
		Deck deck = new Deck();
		Player opponent = new Player(deck.draw());

		System.out.printf("정답: %d%d%d\n", opponent.getNumbers()[0], opponent.getNumbers()[1], opponent.getNumbers()[2]);

		do {
			scanLine();
		} while (inning(player, opponent));
	}

	// Game Logic
	public static boolean inning(Player player, Player opponent) {
		if (isThreeDigits()) {
			player.setNumbers(converter.toArray(converter.toNumber(raw)));
			return decision(player, opponent);
		}
		return true;
	}

	// TODO: go to Input Manager UI
	public static void scanLine() {
		System.out.println("\n세자리 숫자를 입력하세요:");
		raw = scanner.nextLine();
	}

	// TODO: go to Input Manager UI
	public static boolean isThreeDigits() {
		if (!converter.isThreeDigits(raw)) {
			System.out.println("세자리 숫자가 아닙니다.");
			return false;
		}
		return true;
	}

	// TODO: go to Referee UI
	public static boolean decision(Player player, Player opponent) {
		int strikes = referee.countStrikes(player.getNumbers(), opponent.getNumbers());
		int balls = referee.countBall(player.getNumbers(), opponent.getNumbers());

		if (referee.isAnswer(strikes)) {
			System.out.println("3 스트라이크");
			System.out.println("정답입니다.");
			return false;
		}

		if (referee.isNothing(strikes, balls)) {
			System.out.println("낫싱");
			return true;
		}

		if (strikes > 0) {
			System.out.printf("%d 스트라이크 ", strikes);
		}

		if (balls > 0) {
			System.out.printf("%d 볼", balls);
		}

		System.out.println();
		return true;
	}

}

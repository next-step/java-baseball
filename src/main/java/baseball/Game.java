package baseball;

import java.util.Scanner;

public class Game {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean play = true;

		while (play) {
			if (!menu()) {
				break;
			}
			game();
		}
	}

	public static boolean menu() {
		System.out.println("\n게임을 시작하겠습니까? (Y/n):");
		String select = scanner.nextLine();
		return !select.equals("n");
	}

	public static void game() {
		Converter converter = new Converter();
		Referee referee = new Referee();
		Player player = new Player();
		Opponent opponent = new Opponent();

		boolean play = true;

		System.out.printf("정답: %d%d%d\n", opponent.getNumbers()[0], opponent.getNumbers()[1], opponent.getNumbers()[2]);

		while (play) {
			System.out.println("\n세자리 숫자를 입력하세요:");

			String raw = scanner.nextLine();

			if (!converter.isThreeDigits(raw)) {
				System.out.println("세자리 숫자가 아닙니다.");
				continue;
			}

			player.setNumbers(converter.toArray(converter.toNumber(raw)));

			int strikes = referee.countStrikes(player.getNumbers(), opponent.getNumbers());
			int balls = referee.countBall(player.getNumbers(), opponent.getNumbers());

			if (referee.isAnswer(strikes)) {
				System.out.println("3 스트라이크");
				System.out.println("정답입니다.");
				break;
			}

			if (referee.isNothing(strikes, balls)) {
				System.out.println("낫싱");
				continue;
			}

			if (strikes > 0) {
				System.out.printf("%d 스트라이크 ", strikes);
			}

			if (balls > 0) {
				System.out.printf("%d 볼", balls);
			}

			System.out.println();
		}

	}

}

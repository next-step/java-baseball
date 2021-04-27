import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
	private static Computer computer = new Computer();
	private static User user = new User();

	private static List<Integer> userNumbers = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	/*
	 * 숫자야구게임 시작
	 * */
	public static void start() {
		computer.generateNumbers();

		while (true) {
			user.generateNumbers();
			userNumbers = user.getUserNumbers();
			computer.matchResult(userNumbers);
			checkMatch();
		}
	}

	public static void checkMatch() {
		if (computer.getStrikeCount() == 3) {
			endGame();
		}
		computer.showHint();
	}

	public static void endGame() {
		System.out.println("3개의숫자를모두맞히셨습니다!게임종료");
		System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
		restart();
	}

	public static void restart() {
		int restartValue = sc.nextInt();
		if (restartValue == 1) {
			start();
		}
		System.exit(0);
	}
}

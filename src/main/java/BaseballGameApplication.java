import java.util.Scanner;

public class BaseballGameApplication {
	public static Scanner scanner = new Scanner(System.in);
	private final BaseballGameService baseballGameService = new BaseballGameService();

	public static void main(String[] args) {
		BaseballGameApplication game = new BaseballGameApplication();
		game.start();
	}

	private void start() {
		int[] answer = baseballGameService.peek3RandomDistinctNumbers();
		boolean hit = false;
		while (!hit) {
			String guess = guess();
			Hint hint = baseballGameService.getHint(answer, guess);
			System.out.println(hint.getMessage());
			hit = hint.is3Strike();
		}
		choiceBetweenEndOrRestart();
	}

	private String guess() {
		System.out.print("숫자를 입력해 주세요 : ");
		return scanner.nextLine();
	}

	private void choiceBetweenEndOrRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = scanner.nextLine();
		translateChoice(input);
	}

	private void translateChoice(String choice) {
		if (choice.equals("1")) {
			start();
			return;
		}
		if (choice.equals("2")) {
			terminate();
		}
	}

	private void terminate() {
		scanner.close();
		System.exit(0);
	}
}

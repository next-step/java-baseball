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

	}

	private String guess() {
		System.out.print("숫자를 입력해 주세요 : ");
		return scanner.nextLine();
	}

}

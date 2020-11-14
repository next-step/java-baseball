import java.util.Scanner;

public class Game {

	public void start() {
		boolean continueGame;
		Scanner sc = new Scanner(System.in);
		do {
			Computer computer = new Computer();
			computer.initNumbers();

			System.out.print("숫자를 입력해주세요 : ");
			String input = sc.nextLine();

			Score score = computer.calculateScore(input);
			System.out.println(score.getScoreString());

			continueGame = !quit(score);
		} while (continueGame);

	}

	private boolean quit(Score score) {
		if (score.isAllStrike()) {
			Scanner sc = new Scanner(System.in);
			System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			return sc.nextInt() == 2;
		}

		return false;
	}
}

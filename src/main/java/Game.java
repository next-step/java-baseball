import java.util.Scanner;

public class Game {

	public void start() {
		do {
			Computer computer = new Computer();
			play(computer);

		} while (quit());
	}

	private boolean play(Computer computer) {
		Scanner sc = new Scanner(System.in);
		boolean continueGame;
		do {
			System.out.print("숫자를 입력해주세요 : ");
			String inputNumber = sc.nextLine();
			Input input = new Input(inputNumber);

			Score score = computer.calculateScore(input.convertInput());
			System.out.println(score.calculateScore());

			continueGame = score.isAllStrike();
		} while(!continueGame);

		return true;
	}

	private boolean quit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return sc.nextInt() == 2;
	}
}

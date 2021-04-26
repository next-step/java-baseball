package baseball;

import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		GameMain gameMain = new GameMain();
		gameMain.on();
	}

	private void on() {
		while (true) {
			System.out.println("게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.");
			int input = new Scanner(System.in).nextInt();
			isContinue(input);
			startStage();
		}
	}

	private void isContinue(int input) {
		if (input == 1) {
			return;
		}

		if (input == 2) {
			System.exit(0);
		}
	}

	private void startStage() {
		Computer computer = new Computer(BallGenerator.generateBalls());

		while (computer.isRetry()) {
			Player player = new Player();

			computer.calcScore(player.swingNumber());
			computer.printScore();
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}

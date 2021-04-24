import java.util.Scanner;

public class Game {

	Computer computer = new Computer();

	private void init() {
		computer.setBallSet();
		System.out.println("숫자를 입력해주세요");
	}

	private String resultMessage(int strikeCount, int ballCount) {
		StringBuilder sb = new StringBuilder();
		if (strikeCount != 0) {
			sb.append(computer.getStrikeCount()).append("스트라이크 ");
		}

		if (ballCount != 0) {
			sb.append(computer.getBallCount()).append("볼");
		}

		return sb.toString();
	}

	private void success(Scanner scan) {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		if (scan.nextInt() == 1) {
			this.start(scan);
		}
	}

	private void judgment() {
		if (computer.getStrikeCount() == 0 && computer.getBallCount() == 0) {
			System.out.println("낫싱");
		}

		System.out.println(this.resultMessage(computer.getStrikeCount(), computer.getBallCount()));
	}

	public void start(Scanner scan) {
		this.init();
		do {
			this.judgment();
		} while (!computer.result(scan.next()));

		this.success(scan);
	}
}

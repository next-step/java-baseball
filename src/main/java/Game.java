import java.util.Scanner;

public class Game {

	Computer computer = new Computer();

	private void init() {
		computer.setBallSet();
		System.out.println("숫자를 입력해주세요");
	}

	private String resultMessage(int strikeCount, int ballCount) {
		StringBuilder sb = new StringBuilder();
		if (strikeCount != 0 && strikeCount != computer.getMaxBallSize()) {
			sb.append(computer.getStrikeCount()).append("스트라이크 ");
		}

		if (ballCount != 0) {
			sb.append(computer.getBallCount()).append("볼");
		}

		return sb.toString();
	}

	private void successMessage() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private void success(String input) {
		if ("1".equals(input)) {
			try (Scanner scan = new Scanner(System.in)) {
				this.start(scan);
			}
			return;
		}
		if ("2".equals(input)) {
			System.exit(0);
		}
	}

	private void judgment() {
		if (computer.getStrikeCount() != 0 || computer.getBallCount() != 0) {
			System.out.println(this.resultMessage(computer.getStrikeCount(), computer.getBallCount()));
			return;
		}

		System.out.println("낫싱");
	}

	private void hasRetry(Scanner scan) {
		String input;
		do {
			input = scan.next().trim();
			this.success(input);
		} while (!"1".equals(input) && !"2".equals(input));
	}

	public void start(Scanner scan) {
		this.init();

		while (!computer.result(scan.next())) {
			this.judgment();
		}

		this.successMessage();
		this.hasRetry(scan);
	}
}

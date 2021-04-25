import java.util.Scanner;

public class Game {

	Computer computer = new Computer();

	private void reset() {
		computer.setBallSet();
		System.out.println("숫자를 입력해주세요");
	}

	private String answerMessage(int strikeCount, int ballCount) {
		StringBuilder sb = new StringBuilder();
		if (strikeCount != 0 && strikeCount != Computer.MAX_BALL_SIZE) {
			sb.append(computer.getStrikeCount()).append("스트라이크 ");
		}

		if (ballCount != 0) {
			sb.append(computer.getBallCount()).append("볼");
		}

		return sb.toString();
	}

	private void completeMessage() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private void complete(String input) {
		if ("2".equals(input)) {
			System.exit(0);
		}
		if (!"1".equals(input)) {
			return;
		}

		try (Scanner scan = new Scanner(System.in)) {
			this.start(scan);
		}
	}

	private void decide() {
		if (computer.getStrikeCount() != 0 || computer.getBallCount() != 0) {
			System.out.println(this.answerMessage(computer.getStrikeCount(), computer.getBallCount()));
			return;
		}

		System.out.println("낫싱");
	}

	private void hasRetry(Scanner scan) {
		String input;
		do {
			input = scan.next().trim();
			this.complete(input);
		} while (!"1".equals(input) && !"2".equals(input));
	}

	private String checkInput(Scanner scan) {
		final int max = Computer.MAX_BALL_SIZE;
		String pattern = String.format("^[1-9]{%d}$", max);
		String input = scan.next().trim();

		while (input.length() != max || !input.matches(pattern)) {
			System.out.println("1~9까지의 3자리수를 입력해주세요");
			input = scan.next().trim();
		}
		return input;
	}

	public void start(Scanner scan) {
		this.reset();

		while (!computer.answer(checkInput(scan))) {
			this.decide();
		}

		this.completeMessage();
		this.hasRetry(scan);
	}
}

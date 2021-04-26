package javabaseball;

import java.util.Scanner;

public class JavaBaseballGame {
	private static final int BASEBALL_NUMBER_LENGTH = 3;

	private RandomNumberStringGenerator randomNumberStringGenerator;
	private BaseballReferee referee;
	private Scanner scanner;

	private JavaBaseballGame() {
		this.scanner = new Scanner(System.in);
		this.randomNumberStringGenerator = RandomNumberStringGenerator.of();
		this.referee = BaseballReferee.of();
	}

	public static JavaBaseballGame of() {
		return new JavaBaseballGame();
	}

	private String tryAnswer() {
		System.out.println("숫자를 입력해주세요 : ");
		String candidate;

		while (!this.referee.isFair(candidate = this.scanner.next())) {
			System.out.println("다시 시도해주세요.");
		}

		return candidate;
	}

	private void findTarget(String target) {
		boolean isFindTarget = false;

		while (!isFindTarget) {
			String candidate = this.tryAnswer();
			BallCounts ballCounts = referee.decideBalls(candidate, target);
			System.out.println(ballCounts.toString());

			isFindTarget = this.isFindTarget(ballCounts.getStrikeCount());
		}
	}

	private boolean isFindTarget(int strikeCount) {
		if (strikeCount == BASEBALL_NUMBER_LENGTH) {
			System.out.println(BASEBALL_NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}

		return false;
	}

	private boolean isContinueGame() {
		String input;
		while (!isValidInput(input = this.scanner.next())) {
			System.out.println("1 또는 2를 입력해주세요.(시작: 1, 종료: 2)");
		}

		return input.equals("1");
	}

	private boolean isValidInput(String input) {
		return input.equals("1") || input.equals("2");
	}

	public static void main(String[] args) {
		final JavaBaseballGame baseballGame = JavaBaseballGame.of();
		final RandomNumberStringGenerator generator = baseballGame.randomNumberStringGenerator;
		boolean isContinue = true;

		while (isContinue) {
			final String target = generator.generate(BASEBALL_NUMBER_LENGTH);
			baseballGame.findTarget(target);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			isContinue = baseballGame.isContinueGame();
		}
	}
}

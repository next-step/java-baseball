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

	public static void main(String[] args) {
		final JavaBaseballGame baseballGame = JavaBaseballGame.of();
		final RandomNumberStringGenerator generator = baseballGame.randomNumberStringGenerator;
		final BaseballReferee referee = baseballGame.referee;
		final String target = generator.generate(BASEBALL_NUMBER_LENGTH);

		String candidate = baseballGame.tryAnswer();
		BallCounts ballCounts = referee.decideBalls(candidate, target);

		// TODO(jjeda): Implement baseball game
	}

	private String tryAnswer() {
		System.out.println("숫자를 입력해주세요 : ");
		String candidate;

		while (!this.referee.isFair(candidate = this.scanner.next())) {
			System.out.println("다시 시도해주세요.");
		}

		return candidate;
	}
}

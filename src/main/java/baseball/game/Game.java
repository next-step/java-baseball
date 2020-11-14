package baseball.game;

import java.util.List;

public class Game {

	public static final int BALL_COUNT = 3;
	public static final Integer[] ALLOWED_BALL_NUMBERS = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

	private int[] numbers = new int[BALL_COUNT];

	public Game() {
		setNumbers(new UniqueRandomNumbersGenerator(ALLOWED_BALL_NUMBERS).generate(BALL_COUNT));
	}

	public Game(NumbersGenerator numbersGenerator) {
		setNumbers(numbersGenerator.generate(BALL_COUNT));
	}

	private void setNumbers(List<Integer> numbers) {
		for (int i = 0; i < BALL_COUNT; i++) {
			this.numbers[i] = numbers.get(i);
		}
	}

	public GameScore play(Balls balls) {
		GameScore score = new GameScore();

		for (int i = 0; i < BALL_COUNT; i++) {
			play(score, balls.getNumber(i), i);
		}

		return score;
	}

	private void play(GameScore score, int number, int position) {
		if (isStrike(number, position)) {
			score.strike();
			return;
		}
		if (isBall(number, position)) {
			score.ball();
		}
	}

	private boolean isStrike(int number, int position) {
		return number == this.numbers[position];
	}

	private boolean isBall(int number, int position) {
		for (int i = 0; i < BALL_COUNT; i++) {
			if (i == position) {
				continue;
			}
			if (number == this.numbers[i]) {
				return true;
			}
		}
		return false;
	}
}

package baseball.game;

import java.util.List;

public class Game {

	public static final int BALL_COUNT = 3;

	private int[] numbers = new int[BALL_COUNT];

	public Game() {
		setNumbers(new UniqueRandomNumbersGenerator().generate(BALL_COUNT));
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
		return new GameScore();
	}
}

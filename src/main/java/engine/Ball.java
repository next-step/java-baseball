package engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import exception.BaseballException;

public class Ball {
	private String input;
	private int numberOfLength;

	public Ball(String input, int numberOfLength) throws Exception {
		this.numberOfLength = numberOfLength;
		Integer.valueOf(input);
		if (input.length() != numberOfLength) {
			throw new BaseballException(numberOfLength + "의 길이여야 합니다.");
		}
		if (numberOfLength > 10) {
			throw new BaseballException("10보다 작은 길이여야 합니다.");
		}
		this.input = input;
	}

	public Ball(int numberOfLength) {
		this.numberOfLength = numberOfLength;
		ArrayList<Integer> candidate = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			candidate.add(i);
		}
		this.input = "";
		for (int i = 0; i < numberOfLength; i++) {
			this.input += candidate.remove(ThreadLocalRandom.current().nextInt(0, candidate.size()));
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ball ball = (Ball) o;
		return Objects.equals(input, ball.input);
	}

	public int getStrike(Ball ball) {
		int strike = 0;
		for (int i = 0; i < numberOfLength; i++) {
			if (input.charAt(i) == ball.input.charAt(i)) {
				strike++;
			}
		}
		return strike;
	}

	public int getBall(Ball inputBall) {
		int countBall = 0;
		Set<Character> answerSet = makeStringToCharacterSet(input);
		for (int i = 0; i < numberOfLength; i++) {
			if (answerSet.contains(inputBall.input.charAt(i)) && input.charAt(i) != inputBall.input.charAt(i)) {
				countBall++;
			}
		}
		return countBall;
	}

	private Set<Character> makeStringToCharacterSet(String stringInput) {
		Set<Character> answerSet = new HashSet<>();
		for (int i = 0; i < stringInput.length(); i++) {
			answerSet.add(stringInput.charAt(i));
		}
		return answerSet;
	}

	@Override
	public String toString() {
		return "Ball{" +
			"input='" + input + '\'' +
			", numberOfLength=" + numberOfLength +
			'}';
	}
}

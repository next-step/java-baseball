package baseball;

import java.util.List;

public class Computer {

	List<Integer> balls;

	private int strike;
	private int ball;

	public Computer(List<Integer> balls) {
		this.balls = balls;

		for (Integer ball : balls) {
			System.out.println("ball = " + ball);
		}
	}

	public void printScore() {
		if (strike == 0 && ball == 0) {
			System.out.println("포볼");
			return;
		}

		System.out.printf("%d스트라이크, %d볼\n\n", strike, ball);
	}

	public void calcScore(List<Integer> swingNumbers) {
		for (int i = 0; i < 3; i++) {
			countBall(swingNumbers, i);
			countStrike(balls, swingNumbers, i);
		}
		ball -= strike;
	}

	private void countBall(List<Integer> swingNumbers, int i) {
		if (balls.contains(swingNumbers.get(i))) {
			ball++;
		}
	}

	private void countStrike(List<Integer> balls, List<Integer> swingNumber, int i) {
		if (balls.get(i).equals(swingNumber.get(i))) {
			strike++;
		}
	}

	public boolean isRetry() {
		if (strike == 3) {
			return false;
		}

		clearScore();
		return true;
	}

	public void clearScore() {
		strike = 0;
		ball = 0;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}

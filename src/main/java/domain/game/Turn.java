package domain.game;

import domain.target.Ball;
import domain.target.Balls;

import java.util.List;

public class Turn {
	private int ballCount;
	private int strikeCount;

	public Turn(Balls input, Balls target) {
		count(input, target);
	}

	private void count(Balls inputBalls, Balls targetBalls) {
		List<Ball> targetBallList = targetBalls.getBallList();
		List<Ball> inputBallList = inputBalls.getBallList();
		for (int i = 0; i < Balls.BALL_COUNT; i++) {
			ifBallAddBallCount(inputBallList, targetBallList, i);
			ifStrikeAddStrikeCount(inputBallList, targetBallList, i);
		}
	}

	private void ifBallAddBallCount(List<Ball> inputBallList, List<Ball> targetBallList, int index) {
		if (isBall(inputBallList, targetBallList, index)) {
			ballCount++;
		}
	}

	private boolean isBall(List<Ball> inputBallList, List<Ball> targetBallList, int index) {
		return targetBallList.contains(inputBallList.get(index))
			&& !targetBallList.get(index).equals(inputBallList.get(index));
	}

	private void ifStrikeAddStrikeCount(List<Ball> inputBallList, List<Ball> targetBallList, int index) {
		if (isStrike(inputBallList, targetBallList, index)) {
			strikeCount++;
		}
	}

	private boolean isStrike(List<Ball> inputBallList, List<Ball> targetBallList, int index) {
		return targetBallList.contains(inputBallList.get(index))
			&& targetBallList.get(index).equals(inputBallList.get(index));
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}
}

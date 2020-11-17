package NumberBaseballGame;

import java.util.ArrayList;
import java.util.List;

public class BallCountJudgment {

	int[] inputData = null;
	Answer answer;
	BallCount ballCountSum;

	public BallCountJudgment(int[] inputData, Answer answer) {
		this.inputData = inputData;
		this.answer = answer;
	}

	public BallCount getBallCountJudgment() {
		return ballCountSum;
	}

	public void judgeBallCount() {
		List<BallCount> ballCountList = new ArrayList<BallCount>();
		ballCountSum = new BallCount();

		for (int i = 0; i < 3; i++) {
			ballCountList.add(checkBallCount(i, inputData[i]));
		}

		for (int i = 0; i < ballCountList.size(); i++) {
			ballCountSum.addStrikeCount(ballCountList.get(i).getStrike());
			ballCountSum.addBallCount(ballCountList.get(i).getBall());
		}
	}

	public BallCount checkBallCount(int index, int value) {
		BallCount ballCount = new BallCount();

		for (int j = 0; j < 3; j++) {
			ballCount.checkStrike(index, value, j, answer.getAnswer()[j]);
			ballCount.checkBall(index, value, j, answer.getAnswer()[j]);
		}

		return ballCount;
	}

	public void printBallCount() {
		if (ballCountSum.getStrike() != 0) {
			System.out.print(ballCountSum.getStrike() + " 스트라이크    ");
		}
		if (ballCountSum.getBall() != 0) {
			System.out.print(ballCountSum.getBall() + " 볼 ");
		}
		if (ballCountSum.getStrike() + ballCountSum.getBall() == 0) {
			System.out.print("낫씽");
		}
		System.out.print("\n");
	}
}

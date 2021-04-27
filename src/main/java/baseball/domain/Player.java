package baseball.domain;

import java.util.List;

public class Player {

	private int ballCount;
	private int strikeCount;

	public Player() {
		init();
	}

	public void init() {
		this.ballCount = 0;
		this.strikeCount = 0;
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public boolean isFinished() {
		if (this.strikeCount == Game.NUMBER_LENGTH) {
			return true;
		}
		return false;
	}

	private boolean isStrike(int answerNumber, int findNumber) {
		return (answerNumber == findNumber);
	}

	private boolean isBall(List<Integer> answer, int findNumber) {
		return answer.contains(findNumber);
	}

	/*
	 * 판정 Logic
	 */
	public void calculate(List<Integer> answer, List<Integer> input) {
		init();
		for (int index = 0; index < Game.NUMBER_LENGTH; index++) {
			calculateByIndex(answer, index, input.get(index));
		}
	}

	private void calculateByIndex(List<Integer> answer, int index, int findNumber) {
		if (isStrike(answer.get(index), findNumber)) {
			this.strikeCount++;
			return;
		}
		if (isBall(answer, findNumber)) {
			this.ballCount++;
			return;
		}
	}

	/*
	 * Result
	 */
	public String getResult() {
		if (strikeCount == 0 && ballCount == 0) {
			return "낫싱";
		}
		StringBuilder sb = new StringBuilder();
		if (strikeCount > 0) {
			sb.append(strikeCount).append(" 스트라이크 ");
		}
		if (ballCount > 0) {
			sb.append(ballCount).append(" 볼");
		}
		return sb.toString().trim();
	}
}

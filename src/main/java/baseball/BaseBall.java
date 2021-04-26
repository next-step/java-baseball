package baseball;

import static utils.RandomUtils.*;

import java.util.List;

public class BaseBall {
	private static final int DEFAULT_MAX_RANGE = 9;
	private static final int DEFAULT_ANSWER_LENGTH = 3;

	private List<Integer> answer;

	public BaseBall() {
		this.answer = pickRandomInSerialNumbers(DEFAULT_MAX_RANGE, DEFAULT_ANSWER_LENGTH);
	}

	public BaseBall(List<Integer> answer) {
		this.answer = answer;
	}

	public BaseBallDto.Result getUserResult(List<Integer> userAnswer) {
		int strike = getStrike(userAnswer);
		int ball = getBall(userAnswer) - strike;
		boolean isAnswer = strike == this.answer.size();

		return new BaseBallDto.Result(isAnswer, strike, ball);
	}

	public boolean finish(boolean isFinish) {
		if (!isFinish) {
			refresh();
		}

		return isFinish;
	}

	private void refresh() {
		answer = pickRandomInSerialNumbers(DEFAULT_MAX_RANGE, this.answer.size());
	}

	private int getBall(List<Integer> userAnswer) {
		int ball = 0;

		for (int i = 0; i < answer.size(); ++i) {
			if (answer.contains(userAnswer.get(i))) {
				++ball;
			}
		}

		return ball;
	}

	private int getStrike(List<Integer> userAnswer) {
		int strike = 0;

		for (int i = 0; i < answer.size(); ++i) {
			if (answer.get(i).equals(userAnswer.get(i))) {
				++strike;
			}
		}

		return strike;
	}
}

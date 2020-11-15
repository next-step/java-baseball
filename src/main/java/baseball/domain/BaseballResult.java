package baseball.domain;

import static baseball.domain.BaseballStatus.*;

import java.util.List;

import baseball.domain.exception.ResultLengthException;

public class BaseballResult {
	private static final int OUT_COUNT = 3;
	private static final int ZERO = 0;
	private int strikeCount;
	private int ballCount;

	private BaseballResult(List<BaseballStatus> statuses) {
		for (BaseballStatus status : statuses) {
			increaseCount(status);
		}
	}

	private void increaseCount(BaseballStatus status) {
		if (status == STRIKE) {
			strikeCount++;
		}
		if (status == BALL) {
			ballCount++;
		}
	}

	public static BaseballResult of(List<BaseballStatus> statuses) {
		if (statuses.size() > 3) {
			throw new ResultLengthException();
		}
		return new BaseballResult(statuses);
	}

	public boolean isOut() {
		return strikeCount == OUT_COUNT;
	}

	public String getResultMessage() {
		StringBuilder builder = new StringBuilder();
		if (strikeCount > ZERO) {
			builder.append(String.format(STRIKE.getMessageFormat(), strikeCount));
		}
		if (ballCount > ZERO) {
			builder.append(String.format(BALL.getMessageFormat(), ballCount));
		}

		if (strikeCount == ZERO && ballCount == ZERO) {
			builder.append(NOTHING.getMessageFormat());
		}
		return builder.toString();
	}
}

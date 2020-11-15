package baseball.domain;

import static baseball.domain.BaseballStatus.*;

import java.util.List;

import baseball.domain.exception.ResultLengthException;

public class BaseballResult {
	private final List<BaseballStatus> statuses;
	private int strikeCount;
	private int ballCount;

	private BaseballResult(List<BaseballStatus> statuses) {
		this.statuses = statuses;
		for (BaseballStatus status : statuses) {
			if (status == STRIKE) {
				strikeCount++;
			}
			if (status == BALL) {
				ballCount++;
			}
		}
	}

	public static BaseballResult of(List<BaseballStatus> statuses) {
		if (statuses.size() > 3) {
			throw new ResultLengthException();
		}
		return new BaseballResult(statuses);
	}

	public boolean isOut() {
		return strikeCount == 3;
	}

	public String getResultMessage() {
		StringBuilder builder = new StringBuilder();
		if (strikeCount > 0) {
			builder.append(String.format(STRIKE.getMessageFormat(), strikeCount));
		}
		if (ballCount > 0) {
			builder.append(String.format(BALL.getMessageFormat(), ballCount));
		}

		if (strikeCount == 0 && ballCount == 0) {
			builder.append(NOTHING.getMessageFormat());
		}
		return builder.toString();
	}
}

package baseball.domain;

import static baseball.domain.BaseballStatus.*;

import java.util.List;

import baseball.domain.exception.ResultLengthException;

public class BaseballResult {
	private final List<BaseballStatus> statuses;

	private BaseballResult(List<BaseballStatus> statuses) {
		this.statuses = statuses;
	}

	public static BaseballResult of(List<BaseballStatus> statuses) {
		if (statuses.size() > 3) {
			throw new ResultLengthException();
		}
		return new BaseballResult(statuses);
	}

	public String getResultMessage() {
		int strikeCount = 0;
		int ballCount = 0;
		for (BaseballStatus status : statuses) {
			if (status == STRIKE) {
				strikeCount++;
			}
			if (status == BALL) {
				ballCount++;
			}
		}

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

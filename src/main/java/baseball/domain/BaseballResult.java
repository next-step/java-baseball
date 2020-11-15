package baseball.domain;

import java.util.List;

public class BaseballResult {

	private List<BaseballStatus> statuses;
	public BaseballResult(List<BaseballStatus> statuses) {
		this.statuses = statuses;
	}

	public static BaseballResult of(List<BaseballStatus> statuses) {
		return new BaseballResult(statuses);
	}
}

package baseball.domain;

import java.util.Map;
import java.util.Objects;

import baseball.Const;

public class MockGameResult implements GameResult {
	private final Map<BallKind, Integer> resultMap;

	MockGameResult(Map<BallKind, Integer> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public Map<BallKind, Integer> getResultMap() {
		return resultMap;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MockGameResult))
			return false;
		MockGameResult that = (MockGameResult)o;
		return Objects.equals(resultMap.get(BallKind.STRIKE), that.getResultMap().get(BallKind.STRIKE))
			&& Objects.equals(resultMap.get(BallKind.BALL), that.getResultMap().get(BallKind.BALL))
			&& Objects.equals(resultMap.get(BallKind.NOTHING), that.getResultMap().get(BallKind.NOTHING));
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultMap.get(BallKind.STRIKE), resultMap.get(BallKind.BALL),
			resultMap.get(BallKind.NOTHING));
	}

	@Override
	public String toString() {
		return getMessage();
	}

	private String getMessage(BallKind kind) {
		StringBuilder sb = new StringBuilder();
		int value = resultMap.getOrDefault(kind, Const.DEFAULT_VALUE);

		if (value != Const.DEFAULT_VALUE) {
			sb.append(value);
			sb.append(' ');
			sb.append(kind.getMessage());
			sb.append(' ');
		}
		return sb.toString();
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();

		sb.append(getMessage(BallKind.STRIKE));
		sb.append(getMessage(BallKind.BALL));
		sb.append(getMessage(BallKind.NOTHING));
		sb.append(Const.NEW_LINE);

		return sb.toString();
	}
}

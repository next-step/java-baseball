package javabaseball;

import java.util.Objects;

public class BallCounts {
	private final int strikeCount;
	private final int ballCount;

	private BallCounts(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public static BallCounts of(int strikeCount, int ballCount) {
		return new BallCounts(strikeCount, ballCount);
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof BallCounts)) {
			return false;
		}
		BallCounts that = (BallCounts)object;
		return getStrikeCount() == that.getStrikeCount()
			&& getBallCount() == that.getBallCount();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStrikeCount(), getBallCount());
	}
}

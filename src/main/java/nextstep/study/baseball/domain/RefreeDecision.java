package nextstep.study.baseball.domain;

public class RefreeDecision {

	private int strikeCount = 0;
	private int ballCount = 0;
	private int nothingCount = 0;

	public RefreeDecision() {
	}

	public RefreeDecision(int strikeCount, int ballCount, int nothingCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
		this.nothingCount = nothingCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getNothingCount() {
		return nothingCount;
	}

	@Override
	public String toString() {
		return "RefreeDecision{" +
			"strikeCount=" + strikeCount +
			", ballCount=" + ballCount +
			", nothingCount=" + nothingCount +
			'}';
	}
}

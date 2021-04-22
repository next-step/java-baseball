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

	public int addStrikeCount() {
		return strikeCount++;
	}

	public int addStrikeCount(int count) {
		return strikeCount + count;
	}

	public int addBallCount() {
		return ballCount++;
	}

	public int addBallCount(int count) {
		return ballCount + count;
	}

	public int addNothingCount() {
		return nothingCount++;
	}

	public int addNothingCount(int count) {
		return nothingCount + count;
	}

}

package numberBaseBallGame.domain;

public class BallNumberMatchResult {
	private final int GAMENUMBERS_LENGTH= BaseBallConst.GAMENUMBERS_LENGTH;

	private final int strikeCount;
	private final int ballCount;

	public BallNumberMatchResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean isAllMatch(){
		return strikeCount == GAMENUMBERS_LENGTH;
	}
	public boolean isNothing(){
		return strikeCount == 0 && ballCount == 0;
	}
}

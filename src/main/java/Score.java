public class Score {
	private int ballCount = 0;
	private int strikeCount = 0;

	public Score(){}
	public Score(int ballCount, int strikeCount){
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) { 		this.strikeCount = strikeCount; }
}

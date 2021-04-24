package baseball;

public class JavaBaseBallCount {

	public int strikeCount;
	public int ballCount;

	/**
	 * strike와 ball 개수를 리셋한다.
	 */
	public void resetCount() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	/**
	 * 플레이어에게 제공될 힌트 메세지를 만든다.
	 * 
	 * @return
	 */
	public String makeResultMessage() {
		String resultMessage = "";
		resultMessage += strikeCount > 0 && strikeCount < 3 ? String.format("%d 스트라이크", strikeCount) : "";
		resultMessage += ballCount > 0 ? String.format("%d 볼", ballCount) : "";
		resultMessage += strikeCount == 0 && ballCount == 0 ? "낫싱" : "";
		return resultMessage;
	}
}

package baseball.game;

public class BaseballScore {

	private int ball;
	private int strike;

	public BaseballScore(String pitcherNum, String hitterNum) {
		judgeScore(pitcherNum, hitterNum);
	}

	private void clearScore() {
		this.ball = 0;
		this.strike = 0;
	}

	public String getScoreStr() {
		if (ball == 0 && strike == 0) {
			return "낫싱";
		}
		return strikeMessage() + ballMessage();
	}

	private String strikeMessage() {
		String str = "";
		if (strike > 0) {
			str += strike + "스트라이크 ";
		}
		return str;
	}

	private String ballMessage() {
		String str = "";
		if (ball > 0) {
			str += ball + "볼";
		}
		return str;
	}

	public boolean isAnswer() {
		return this.strike == BaseballGame.MAX_NUM_SIZE;
	}

	private void judgeScore(String pitcherNum, String hitterNum) {
		clearScore();

		for (int i = 0; i < hitterNum.length(); i++) {
			int pitcherMatchIndex = pitcherNum.indexOf(hitterNum.charAt(i));
			incBall(i, pitcherMatchIndex);
			incStrike(i, pitcherMatchIndex);
		}
	}

	private void incStrike(int hitterNumIndex, int pitcherMatchIndex) {
		if (pitcherMatchIndex != -1 && hitterNumIndex == pitcherMatchIndex) {
			this.strike++;
		}
	}

	private void incBall(int hitterNumIndex, int pitcherMatchIndex) {
		if (pitcherMatchIndex != -1 && hitterNumIndex != pitcherMatchIndex) {
			this.ball++;
		}
	}
}

package game.baseball;

import java.util.Set;

public class Umpire {

	private int balls = 0;

	private int strikes = 0;

	private Hitter hitter;

	private Pitcher pitcher;


	public boolean isOut() {
		return strikes == 3;
	}

	public Hitter getHitter() {
		return hitter;
	}

	public void setHitter(Hitter hitter) {
		this.hitter = hitter;
	}

	public Pitcher getPitcher() {
		return pitcher;
	}

	public void setPitcher(Pitcher pitcher) {
		this.pitcher = pitcher;
	}

	public void judge() {
		for (int i = 0; i < pitcher.getPitches().length; i++) {
			callBall(pitcher.getPitches()[i], hitter.getHittingNumbers());
			callStrikes(pitcher.getPitches()[i], (int) hitter.getHittingNumbers().toArray()[i]);
		}
	}

	public void callBall(int pitch, Set<Integer> hits) {
		if (hits.contains(pitch)) {
			balls++;
		}
	}

	public void callStrikes(int pitch, int hit) {
		if (pitch == hit) {
			strikes++;
		}
	}

	public String speakJudge() {
		if (strikes > 0 && balls == 0) {
			return String.format("%o 스트라이크", strikes);
		}

		if (strikes == 0 && balls > 0) {
			return String.format("%o 볼", balls);
		}

		if (strikes > 0 && balls > 0) {
			return String.format("%o 스트라이크 %o 볼", strikes, balls);
		}

		if (strikes == 0 && balls == 0) {
			return "낫싱";
		}

		if (strikes == 3) {
			return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		}
		return "";
	}
}

package domain;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구점수
 **/
public class Score {
	public static final int ALL_STRIKE = 3;

	private int strike;
	private int ball;

	public Score() {
		strike = 0;
		ball = 0;
	}

	public void addStrike() {
		strike++;
	}

	public void addBall() {
		ball++;
	}

	public boolean isAllStrike() {
		return this.strike == ALL_STRIKE;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isNothing() {
		return strike == 0 && ball == 0;
	}

}

package jbh.numberbaseball;

import jbh.utils.BallUtil;

public class PcTeam {

	private String ball;

	public void initNewBall() {
		this.ball = BallUtil.makeBall(3);
	}

	public String getBall() {
		return ball;
	}
}

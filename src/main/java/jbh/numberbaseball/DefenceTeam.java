package jbh.numberbaseball;

import jbh.utils.BallUtil;

public class DefenceTeam {

	private String ball;

	public DefenceTeam() {
		initNewBall();
	}

	public void initNewBall() {
		this.ball = BallUtil.makeBall(3);
	}

	public String getBall() {
		return ball;
	}
}

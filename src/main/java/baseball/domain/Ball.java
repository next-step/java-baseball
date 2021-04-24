package baseball.domain;

public class Ball {
	
	private String ball;
		
	public Ball() {
		
	}

	public Ball(String num) {
		this.ball = num;
	}

	public String getBall() {
		return ball;
	}

	public void setBall(String ball) {
		this.ball = ball;
	}
	
}

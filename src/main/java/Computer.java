import java.util.Set;
import java.util.TreeSet;

public class Computer {

	static final int MAX_BALL_SIZE = 3;
	private int strikeCount = 0;
	private int ballCount = 0;
	private String ball = "";

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	private Set<Integer> ballSet = new TreeSet<>();

	private int randomNumber(int min, int max) {
		return (int)(Math.random() * max + min);
	}

	private Set<Integer> getBallSet() {
		return ballSet;
	}

	public String getBall() {
		if (ball != null && !"".equals(ball.trim())) {
			return ball;
		}

		StringBuilder sb = new StringBuilder();
		for (Integer i : this.getBallSet()) {
			sb.append(i);
		}
		ball = sb.toString();
		return ball;
	}

	public void setBallSet() {
		Set<Integer> ballSet = new TreeSet<>();
		int randomMin = 1;
		int randomMax = 9;

		while (ballSet.size() != Computer.MAX_BALL_SIZE) {
			ballSet.add(this.randomNumber(randomMin, randomMax));
		}
		this.ballSet = ballSet;
		this.ball = null;
	}

	protected void checkRuleStrike(char ball, int index) {
		if (this.getBall().indexOf(ball) == index) {
			this.strikeCount++;
		}
	}

	protected void checkRuleBall(char ball, int index) {
		final String strBall = this.getBall();
		if (strBall.indexOf(ball) != -1 && strBall.indexOf(ball) != index) {
			this.ballCount++;
		}
	}

	public boolean answer(String input) {
		this.strikeCount = 0;
		this.ballCount = 0;
		int index = 0;
		for (char c : input.toCharArray()) {
			this.checkRuleStrike(c, index);
			this.checkRuleBall(c, index);
			index++;
		}

		return this.getStrikeCount() == Computer.MAX_BALL_SIZE;
	}
}

import java.util.Set;
import java.util.TreeSet;

public class Computer {

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

	private int numberRandom(int min, int max) {
		return (int)(Math.random() * max + min);
	}

	public int getMaxBallSize() {
		return 3;
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

		while (ballSet.size() != this.getMaxBallSize()) {
			ballSet.add(this.numberRandom(randomMin, randomMax));
		}
		this.ballSet = ballSet;
	}

	private void strikeRuleCheck(char ball, int index) {
		if (this.getBall().indexOf(ball) == index) {
			this.strikeCount++;
		}
	}

	private void ballRuleCheck(char ball, int index) {
		final String strBall = this.getBall();
		if (strBall.indexOf(ball) != -1 && strBall.indexOf(ball) != index) {
			this.ballCount++;
		}
	}

	public boolean result(String input) {
		this.strikeCount = 0;
		this.ballCount = 0;
		int index = 0;
		for (char c : input.toCharArray()) {
			this.strikeRuleCheck(c, index);
			this.ballRuleCheck(c, index);
			index++;
		}

		return this.getStrikeCount() == this.getMaxBallSize();
	}
}

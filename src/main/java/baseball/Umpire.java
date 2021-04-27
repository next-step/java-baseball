package baseball;

public class Umpire {
	private boolean isStrike() {
		return true;
	}

	private boolean isBall() {
		return true;
	}

	public Score judge(String attackNumbers, String defenceNumbers) {
		return new Score(0, 0);
	}
}

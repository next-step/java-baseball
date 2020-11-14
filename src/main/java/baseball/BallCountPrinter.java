package baseball;

public class BallCountPrinter {

	private BallCount ballCount;

	public BallCountPrinter(BallCount ballCount) {
		this.ballCount = ballCount;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		if (ballCount.hasStrike()) {
			sb.append(ballCount.getStrikeText());
		}

		if (ballCount.hasBall()) {
			sb.append(ballCount.getBallText());
		}

		if (ballCount.isNoting()) {
			sb.append(GameResource.TEXT_NOTHING);
		}

		System.out.println(sb.toString().trim());
	}
}

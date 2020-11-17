package baseball;

public class Computer {
	private final Balls computerBalls;

	public Computer() {
		computerBalls = new Balls();
	}

	public Score requestUserBalls(Balls userBalls) {
		return computerBalls.compare(userBalls);
	}
}

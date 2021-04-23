package baseball.domain;

public class Computer {

	private BallNumber ballNumber;

	public Computer() {
		this.ballNumber = new BallNumber();
	}

	public BallNumber getBallNumber() {
		return this.ballNumber;
	}
}

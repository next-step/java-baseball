package baseball.controller.dto;

public class GuessFeedbackResponse {
	private int numStrike;
	private int numBall;

	public GuessFeedbackResponse(int numStrike, int numBall) {
		this.numStrike = numStrike;
		this.numBall = numBall;
	}

	public int getNumStrike() {
		return numStrike;
	}

	public int getNumBall() {
		return numBall;
	}
}

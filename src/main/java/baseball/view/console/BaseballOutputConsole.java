package baseball.view.console;

import baseball.controller.dto.GuessFeedbackResponse;
import baseball.view.BaseballOutput;

public class BaseballOutputConsole implements BaseballOutput {
	private final String GUESS_FEEDBACK_STRIKE_MESSAGE = " 스트라이크 ";
	private final String GUESS_FEEDBACK_BALL_MESSAGE = " 볼";
	private final String GUESS_FEEDBACK_NOTHING_MESSAGE = "낫싱";

	@Override
	public void returnGuessFeedbackResponse(GuessFeedbackResponse response) {
		printNumStrike(response);
		printNumBall(response);
		printNothing(response);
		System.out.println();
	}

	private void printNumStrike(GuessFeedbackResponse response) {
		if (response.getNumStrike() > 0) {
			System.out.print(response.getNumStrike() + GUESS_FEEDBACK_STRIKE_MESSAGE);
		}
	}

	private void printNumBall(GuessFeedbackResponse response) {
		if (response.getNumBall() > 0) {
			System.out.print(response.getNumBall() + GUESS_FEEDBACK_BALL_MESSAGE);
		}
	}

	private void printNothing(GuessFeedbackResponse response) {
		if (response.getNumStrike() == 0 && response.getNumBall() == 0) {
			System.out.print(GUESS_FEEDBACK_NOTHING_MESSAGE);
		}
	}
}

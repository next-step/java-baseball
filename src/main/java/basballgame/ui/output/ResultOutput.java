package basballgame.ui.output;

import basballgame.ui.HintMessages;

public class ResultOutput {

	public static void print(int strike, int ball) {

		if (strike == 0 && ball == 0) {
			Output.print(HintMessages.NOTHING_TEXT);
			return;
		}

		if (strike > 0 && ball <= 0) {
			Output.print(HintMessages.strikeMessage(strike));
			return;
		}

		if (strike <= 0 && ball > 0) {
			Output.print(HintMessages.ballMessage(ball));
			return;
		}

		Output.print(HintMessages.strikeAndBallMessage(strike, ball));
	}
}

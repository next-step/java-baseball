package UI;

import UI.msg.OutputMessage;
import domain.baseballRule.BaseballResult;

public class Output {

	public static void printBaseballResult(BaseballResult baseballResult) {

		if (baseballResult.isNothing()) {
			System.out.print(OutputMessage.NOTHING);
			return;
		}

		if (baseballResult.getStrikeCount() > 0) {
			System.out.print(OutputMessage.STRIKE);
		}

		if (baseballResult.getBallCount() > 0) {
			System.out.print(OutputMessage.BALL);
		}

		if (baseballResult.isThreeStrike()) {
			System.out.print(OutputMessage.THREE_STRIKE);
		}
	}
}

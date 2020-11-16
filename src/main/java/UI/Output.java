package UI;

import UI.msg.OutputMessage;
import domain.baseballRule.BaseballResult;

public class Output {

	public static void printBaseballResult(BaseballResult baseballResult) {

		if (baseballResult.isNothing()) {
			System.out.println(OutputMessage.NOTHING);
			return;
		}

		if (baseballResult.isStrikeAndBall()) {
			System.out.println(baseballResult.getStrikeCount() + OutputMessage.STRIKE +" " +baseballResult.getBallCount() + OutputMessage.BALL);
			return;
		}

		if (baseballResult.isOnlyStrike()) {
			System.out.println(baseballResult.getStrikeCount() + OutputMessage.STRIKE);
			return;
		}

		if (baseballResult.isOnlyBall()) {
			System.out.println(baseballResult.getBallCount() + OutputMessage.BALL);
			return;
		}

		if (baseballResult.isThreeStrike()) {
			System.out.println(OutputMessage.THREE_STRIKE);
			return;
		}
	}
}

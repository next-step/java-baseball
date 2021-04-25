package basballgame.ui.output;

import basballgame.game.BaseballResult;
import basballgame.ui.GameMessages;
import basballgame.ui.HintMessages;

public class Output {
	public static void print(String msg) {
		System.out.println(msg);
	}
	public static void gameOverPrint() {
		print(GameMessages.GAME_OVER_TEXT);
	}
	public static void baseballResultPrint(BaseballResult result){
			if (result.isNothing()) {
				Output.print(HintMessages.NOTHING_TEXT);
				return;
			}

			if (result.onlyStrike()) {
				Output.print(HintMessages.strikeMessage(result.getStrike()));
				return;
			}

			if (result.onlyBall()) {
				Output.print(HintMessages.ballMessage(result.getBall()));
				return;
			}

			Output.print(HintMessages.strikeAndBallMessage(result.getStrike(), result.getBall()));

	}
}

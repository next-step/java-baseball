package basballgame.ui.output;

import basballgame.game.BaseballResult;
import basballgame.ui.GameMessages;
import basballgame.ui.HintMessages;

public class Output {
	public static void print(String msg) {
		System.out.print(msg);
	}
	public static void println(String msg) {
		System.out.println(msg);
	}
	public static void gameOverPrint() {
		println(GameMessages.GAME_OVER_TEXT);
	}
	public static void baseballResultPrint(BaseballResult result){
			if (result.isNothing()) {
				Output.println(HintMessages.NOTHING_TEXT);
				return;
			}

			if (result.onlyStrike()) {
				Output.println(HintMessages.strikeMessage(result.getStrike()));
				return;
			}

			if (result.onlyBall()) {
				Output.println(HintMessages.ballMessage(result.getBall()));
				return;
			}

			Output.println(HintMessages.strikeAndBallMessage(result.getStrike(), result.getBall()));
	}
}

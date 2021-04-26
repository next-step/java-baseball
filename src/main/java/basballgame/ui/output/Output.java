package basballgame.ui.output;

import java.util.function.Predicate;
import java.util.function.Supplier;

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
		printlnWithCondition(result::isNothing, HintMessages.NOTHING_TEXT);
		printlnWithCondition(result::onlyStrike, HintMessages.strikeMessage(result.getStrike()));
		printlnWithCondition(result::onlyBall, HintMessages.ballMessage(result.getBall()));
		printlnWithCondition(result::isStrikeAndBall, HintMessages.strikeAndBallMessage(result.getStrike(), result.getBall()));
	}

	private static void printlnWithCondition(Supplier<Boolean> result, String messages) {
		if (result.get()) {
			Output.println(messages);
		}
	}
}

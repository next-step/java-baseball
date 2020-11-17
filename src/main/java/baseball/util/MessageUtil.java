package baseball.util;

import baseball.constant.GameResultType;
import baseball.constant.GameCommandType;
import baseball.domain.GameScore;

public class MessageUtil {

	private MessageUtil() {
		throw new IllegalAccessError("Utility class");
	}

	private static String REQUIRED_NUMBER = "숫자를 입력해주세요 : ";
	private static String GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static String SELECT_GAME =
		"게임을 새로 시작하려면 " + GameCommandType.RETRY.getCommand() + ", 종료하려면 " + GameCommandType.EXIT.getCommand()
			+ "를 입력하세요.";

	public static void printStartMessage() {
		System.out.println(REQUIRED_NUMBER);
	}

	//게임 결과를 받아 출력하는 메서드
	public static void printGameResult(GameScore gameScore) {

		StringBuilder messageBuilder = new StringBuilder();

		if (gameScore.isExistStrikeCount()) {
			messageBuilder
				.append(gameScore.getStrike() + " " + GameResultType.STRIKE.getValue() + " ");
		}
		if (gameScore.isExistBallCount()) {
			messageBuilder.append(gameScore.getBall() + " " + GameResultType.BALL.getValue());
		}
		if (!gameScore.isExistBallCount() && !gameScore.isExistStrikeCount()) {
			messageBuilder.append(GameResultType.NOTHING.getValue());
		}

		System.out.println(messageBuilder.toString());

		if (gameScore.isGameClear()) {
			System.out.println(GAME_CLEAR);
		}

	}

	public static void printRetryAskMessage() {
		System.out.println(SELECT_GAME);
	}

}

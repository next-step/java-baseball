package io.github.sejoung.baseball.message;

import static io.github.sejoung.baseball.constants.GameMessage.*;
import static io.github.sejoung.baseball.constants.PlayMessage.*;

import io.github.sejoung.baseball.constants.PlayMessage;

public abstract class MessageMaker {

	public static String getPlayMessage(int strikeCount, int ballCount) {

		if (strikeCount == 3) {
			return endGameMessage();
		}

		if (strikeCount == 0 && ballCount == 0) {
			return notThingMessage();
		}

		return strikeAndBallMessage(strikeCount, ballCount);
	}

	private static String strikeAndBallMessage(int strikeCount, int ballCount) {
		StringBuilder sb = new StringBuilder();
		if (strikeCount > 0) {
			sb.append(strikeMessage(strikeCount));
			sb.append(" ");
		}

		if (ballCount > 0) {
			sb.append(ballMessage(ballCount));
		}
		return sb.toString();
	}

	private static String notThingMessage() {
		return NOTHING.getMessage();
	}

	private static String endGameMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append(SUCCESS.getMessage());
		sb.append("\n");
		sb.append(RESTART.getMessage());
		return sb.toString();
	}

	private static String strikeMessage(int number) {
		return formatMessage(STRIKE, number);
	}

	private static String ballMessage(int number) {
		return formatMessage(BALL, number);
	}

	private static String formatMessage(PlayMessage playMessage, int number) {
		return String.format(playMessage.getMessage(), number);
	}
}

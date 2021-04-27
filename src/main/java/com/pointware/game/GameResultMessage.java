package com.pointware.game;

import java.util.ArrayList;
import java.util.List;

import com.pointware.game.validation.GameNumberValidationResult;

public class GameResultMessage {

	private GameNumberValidationResult result;

	public GameResultMessage(GameNumberValidationResult result) {
		this.result = result;
	}

	public static GameResultMessage of(GameNumberValidationResult result) {
		return new GameResultMessage(result);
	}

	public String getMessage() {
		List<String> messages = new ArrayList<>();
		messages.add(getStrikeMessage());
		messages.add(getBallMessage());
		messages.add(getNothingMessage());
		return joinMessage(messages);
	}

	private String getStrikeMessage() {
		if (result.getStrikeCount() < 1) {
			return "";
		}
		return result.getStrikeCount() + " 스트라이크";
	}

	private String getBallMessage() {
		if (result.getBallCount() < 1) {
			return "";
		}
		return result.getBallCount() + "볼";
	}

	private String getNothingMessage() {
		if (result.isNothing()) {
			return "낫싱";
		}
		return "";
	}

	private String joinMessage(List<String> messages) {
		StringBuilder messageBuilder = new StringBuilder();
		for (String message : messages) {
			appendMessage(messageBuilder, message);
		}
		return messageBuilder.toString().trim();
	}

	private void appendMessage(StringBuilder builder, String message) {
		if (message.isEmpty()) {
			return;
		}
		builder.append(message).append(" ");
	}
}

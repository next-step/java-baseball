package com.coderhglee.game.baseball;

import java.util.ArrayList;
import java.util.function.Function;

import com.coderhglee.game.number.NumberCompareResult;


public enum BaseballGameStatus {
	WIN("3개의 숫자를 모두 맞히셨습니다!", 3),
	NOTING("낫싱", 0),
	HINT(result -> {
		ArrayList<String> scoreMessage = new ArrayList<>();
		setScoreMessage(result.getNumberAndDigitSameScore(), scoreMessage, " 스트라이크");
		setScoreMessage(result.getNumberSameScore(), scoreMessage, "볼");
		return String.join(" ", scoreMessage);
	});

	int statusScore;

	private static void setScoreMessage(int score, ArrayList<String> scoreMessage, String comment) {
		if (score > NOTING.getStatusScore()) {
			scoreMessage.add(score + comment);
		}
	}

	private final String messageForUser;
	private Function<NumberCompareResult, String> expression;

	BaseballGameStatus(String messageForUser, int statusScore) {
		this.messageForUser = messageForUser;
		this.statusScore = statusScore;
	}


	BaseballGameStatus(Function<NumberCompareResult, String> expression) {
		this.messageForUser = "";
		this.expression = expression;
	}

	public String getMessageForUser() {
		return messageForUser;
	}

	public String getMessageForUser(NumberCompareResult numberCompareResult) {
		return expression.apply(numberCompareResult);
	}

	public int getStatusScore() {
		return statusScore;
	}
}

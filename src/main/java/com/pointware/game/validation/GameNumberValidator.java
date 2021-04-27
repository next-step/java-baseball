package com.pointware.game.validation;

public class GameNumberValidator {
	public GameNumberValidationResult validate(int computerNumber, int playerNumber) {
		String computerNumberString = String.valueOf(computerNumber);
		String playerNumberString = String.valueOf(playerNumber);

		return new GameNumberValidationResult(
			getTotalStrikeCount(computerNumberString, playerNumberString),
			getTotalBallCount(computerNumberString, playerNumberString)
		);
	}

	private int getTotalStrikeCount(String computer, String player) {
		int totalStrikeCount = 0;
		for (int i = 0; i < 3; i++) {
			totalStrikeCount += getStrikeCount(computer.charAt(i), player.charAt(i));
		}
		return totalStrikeCount;
	}

	private int getTotalBallCount(String computer, String player) {
		int totalBallCount = 0;
		for (int i = 0; i < 3; i++) {
			totalBallCount += getBallCount(computer, player.charAt(i), i);
		}
		return totalBallCount;
	}

	private int getStrikeCount(char computer, char player) {
		if (computer == player) {
			return 1;
		}
		return 0;
	}

	private int getBallCount(String computer, char player, int index) {
		if (computer.indexOf(player) == -1 || computer.indexOf(player) == index) {
			return 0;
		}
		return 1;
	}

}

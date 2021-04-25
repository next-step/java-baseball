package io.github.sejoung.baseball;

import static io.github.sejoung.baseball.constants.GameMessage.*;
import static io.github.sejoung.baseball.constants.PlayMessage.*;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGamePlayerNumber {

	private int strikeCount;
	private int ballCount;
	private final List<Integer> playerNumbers;
	private final List<Integer> computerNumber;
	private final TextOutput output;
	private final BaseBallGameStatus status;

	public BaseBallGamePlayerNumber(List<Integer> computerNumber, TextOutput output, BaseBallGameStatus status,
		String input) {
		this.computerNumber = computerNumber;
		this.output = output;
		this.status = status;
		this.playerNumbers = playerInputTransperList(input);
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public void check() {
		threeStrikeCheck();
		if (this.strikeCount < 3) {
			strikeAndBallCheck();
		}
		makeMessage();
	}

	private void strikeAndBallCheck() {
		for (int i = 0; i < 3; i++) {
			int numberIndex = computerNumber.indexOf(playerNumbers.get(i));
			strikeCheck(i, numberIndex);
			ballCheck(i, numberIndex);
		}
	}

	private void strikeCheck(int i, int numberIndex) {
		if (i == numberIndex) {
			strikeCount++;
		}
	}

	private void ballCheck(int i, int numberIndex) {
		if (i != numberIndex && numberIndex > -1) {
			ballCount++;
		}
	}

	private void makeMessage() {
		if (strikeCount == 0 && ballCount == 0) {
			output.printMessages(NOTHING);
		}
		if (strikeCount > 0 && strikeCount < 3) {
			output.printMessages(getStrike(strikeCount));
		}
		if (ballCount > 0) {
			output.printMessages(getBall(ballCount));
		}
		if (strikeCount == 3) {
			output.printMessages(getStrike(3), SUCCESS, RESTART);
		}
	}

	private void threeStrikeCheck() {
		if (computerNumber.equals(playerNumbers)) {
			status.restartGame();
			this.strikeCount = 3;
		}
	}

	private List<Integer> playerInputTransperList(String input) {
		List<Integer> playerNumbers = new ArrayList<>();
		for (char number : input.toCharArray()) {
			playerNumbers.add(Character.getNumericValue(number));
		}
		return playerNumbers;
	}
}

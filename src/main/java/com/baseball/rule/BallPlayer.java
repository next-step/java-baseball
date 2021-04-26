package com.baseball.rule;

import java.util.ArrayList;

import com.baseball.exception.GameException;
import com.baseball.message.ValidateMessage;

public class BallPlayer {

	private final static int LENGTH = 3;

	private String inputText;
	private ArrayList<Integer> inputNumbers;

	public BallPlayer(String inputText) {
		this.inputText = inputText.trim();

		validateInputText();
		convertStringToIntList();
	}

	public ArrayList<Integer> getInputNumbers() {
		return inputNumbers;
	}

	private void convertStringToIntList() {
		String[] inputCharacters = this.inputText.split("");
		this.inputNumbers = new ArrayList<>();

		for (String inputCharacter : inputCharacters) {
			this.inputNumbers.add(Integer.parseInt(inputCharacter));
		}
	}

	public void validateInputText() {
		if (!isProperLength()) {
			GameException.throwValidationException(ValidateMessage.LENGTH);
		}
		if (!isNumeric()) {
			GameException.throwValidationException(ValidateMessage.NUMERIC);
		}
	}

	public boolean isProperLength() {
		return this.inputText.length() == LENGTH;
	}

	public boolean isNumeric() {
		try {
			Integer.parseInt(this.inputText);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}

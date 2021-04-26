package com.baseball.rule;

import java.util.ArrayList;

import com.baseball.exception.GameException;
import com.baseball.message.ValidateMessage;

public class BallComparator {

	private final static int LENGTH = 3;

	private String inputText;
	private ArrayList<Integer> inputNumbers;

	private ArrayList<Integer> generatedNumbers;

	public BallComparator(String inputText, ArrayList<Integer> generatedNumbers) {
		this.inputText = inputText.trim();
		this.generatedNumbers = generatedNumbers;

		validateInputText();
	}

	private void convertStringToIntList() {
		String[] inputCharacters = this.inputText.split("");
		this.inputNumbers = new ArrayList<Integer>();

		for (String inputCharacter : inputCharacters) {
			this.inputNumbers.add(Integer.parseInt(inputCharacter));
		}
	}

	public void validateInputText() {
		if (!isProperLength()) {
			//GameException.throwValidationException(ValidateMessage.LENGTH);
		}
		if (!isNumeric()) {
			//GameException.throwValidationException(ValidateMessage.NUMERIC);
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

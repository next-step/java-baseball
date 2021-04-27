package com.baseball.rule;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.baseball.exception.GameException;
import com.baseball.message.ValidateMessage;

public class BallPlayer {

	private final static int LENGTH = 3;

	private String inputText;
	private ArrayList<Integer> inputNumbers;

	public BallPlayer() {
		this("");
	}

	public BallPlayer(String inputText) {
		this.inputText = inputText.trim();

		validateInputText();
		convertStringToIntList();
	}

	public ArrayList<Integer> getInputNumbers() {
		return inputNumbers;
	}

	public void validateInputText() {
		if (!isThreeDigits()) {
			GameException.throwValidationException(ValidateMessage.THREE_DIGITS);
		}
	}

	public void convertStringToIntList() {
		String[] inputCharacters = this.inputText.split("");
		this.inputNumbers = new ArrayList<>();

		for (String inputCharacter : inputCharacters) {
			this.inputNumbers.add(Integer.parseInt(inputCharacter));
		}
	}

	public boolean isThreeDigits() {
		Pattern pattern = Pattern.compile("^[1-9]{" + LENGTH + ",}$");
		Matcher matcher = pattern.matcher(this.inputText);

		return matcher.matches();
	}

}

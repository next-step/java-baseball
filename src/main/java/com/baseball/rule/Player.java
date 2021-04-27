package com.baseball.rule;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.baseball.message.UIMessage;
import com.baseball.message.ValidateMessage;

public class Player {

	private final static int LENGTH = 3;
	private final Scanner scanner;

	private String inputedText;
	private String validatedText;
	private ArrayList<Integer> validatedNumbers;

	public Player() {
		this(new Scanner(System.in));
	}

	public Player(Scanner scanner) {
		this.scanner = scanner;
	}

	public void recieveScannerText() {
		System.out.print(UIMessage.TRY_INFO);

		String inputText = scanner.nextLine().trim();

		inputedText = inputText.trim();
	}

	public void setValidatedText() {
		boolean keepGoing = true;
		while (keepGoing) {
			recieveScannerText();
			keepGoing = !isThreeDigits();
			System.out.println(ValidateMessage.THREE_DIGITS);
		}
		validatedText = inputedText;
	}

	public void convertStringToIntList() {
		String[] inputCharacters = validatedText.split("");
		validatedNumbers = new ArrayList<>();

		for (String inputCharacter : inputCharacters) {
			validatedNumbers.add(Integer.parseInt(inputCharacter));
		}
	}

	public ArrayList<Integer> getValidatedNumbers() {
		return validatedNumbers;
	}

	public boolean isThreeDigits() {
		Pattern pattern = Pattern.compile("^[1-9]{" + LENGTH + ",}$");
		Matcher matcher = pattern.matcher(inputedText);

		return matcher.matches();
	}

}

package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class View {
	public String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void output(String inputText) {
		System.out.println(inputText);
	}

	public String viewUserNumberInput() {
		String inputText = null;
		boolean isValid = false;
		while (!isValid) {
			inputText = input();
			isValid = validInputText(inputText);
		}
		return inputText;
	}

	public boolean validInputText(String inputText) {
		try {
			checkLength(inputText);
			checkNumber(inputText);
			checkDuplicateNumbers(inputText);
		} catch (InputValidException inputValidException) {
			return false;
		}
		return true;
	}

	public void checkLength(String inputText) throws InputValidException {
		if (inputText.length() != GameNumberRule.LENGTH.getValue()) {
			throw new InputValidException(GameNumberRule.LENGTH.getValue() + "자리 숫자를 입력해주세요.");
		}
	}

	public void checkNumber(String inputText) throws InputValidException {
		if (!Pattern.matches("^[1-9]*$", inputText)) {
			throw new InputValidException("숫자만 입력해주세요.");
		}
	}

	public void checkDuplicateNumbers(String inputText) throws InputValidException {
		Set<String> inputSet = new HashSet<>();
		inputSet.addAll(Arrays.asList(inputText.split("")));
		if (inputSet.size() != GameNumberRule.LENGTH.getValue()) {
			throw new InputValidException("중복되지 않은 숫자를 입력해주세요.");
		}
	}

	public void viewGameResultOutput(GameResult gameResult) {
		output(gameResult.toString());
	}
}


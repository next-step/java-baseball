package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class View {
	public String input() {
		Scanner scanner = new Scanner(System.in);
		String inputText = null;
		boolean isValid = false;
		while (!isValid) {
			inputText = scanner.next();
			try {
				isValid = validInputText(inputText);
			} catch (InputValidException inputValidException) {}
		}
		return inputText;
	}

	public void output(String inputText) {
		System.out.println(inputText);
	}

	public boolean validInputText(String inputText) throws InputValidException {
		checkNumberLength(inputText);
		checkDuplicateNumbers(inputText);
		return true;
	}

	public void checkNumberLength(String inputText) throws InputValidException {
		if (!Pattern.matches("^[1-9]{1}[1-9]{1}[1-9]{1}$", inputText)) {
			throw new InputValidException("3자리 숫자를 입력해주세요.");
		}
	}

	public void checkDuplicateNumbers(String inputText) throws InputValidException {
		Set<String> inputSet = new HashSet<>();
		inputSet.addAll(Arrays.asList(inputText.split("")));
		if (inputSet.size() != GameNumberRule.LENGTH.getValue()) {
			throw new InputValidException("중복되지 않은 숫자를 입력해주세요.");
		}
	}

	public void gameResultOutput(GameResult gameResult) {
		output(gameResult.toString());
	}

	public static void main(String[] args) {
		View view = new View();
		view.input();
	}
}


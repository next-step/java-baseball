package service;

import java.util.Scanner;

import constants.GameNumberRule;
import exception.InputValidException;
import util.ValidationCheckUtil;
import vo.GameResult;

public class View {
	private static ValidationCheckUtil valid = new ValidationCheckUtil();

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
			valid.checkLength(inputText, GameNumberRule.LENGTH.getValue() + "자리 숫자를 입력해주세요.");
			valid.checkNumber(inputText, "숫자만 입력해주세요.");
			valid.checkDuplicateNumbers(inputText, "중복되지 않은 숫자를 입력해주세요.");
		} catch (InputValidException inputValidException) {
			return false;
		}
		return true;
	}

	public void viewGameResultOutput(GameResult gameResult) {
		output(gameResult.toString());
	}
}


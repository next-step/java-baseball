package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Gamer {
	ArrayList<String> userInputNumbers = new ArrayList<>();

	public ArrayList<String> getUserInputNumbers() {
		return userInputNumbers;
	}

	public void inputNumberFromUser() {
		System.out.println("숫자를 입력해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		String inputNumbers = scanner.nextLine();
	}

	private void chekcInputNumber(String input) {

	}

	private void checkDuplicateNumber(String input) {
		LinkedHashSet<String> linkedHashMap = new LinkedHashSet<>();

		for (char number : input.toCharArray()) {
			int convertNumberFromChar = parseIntOrThrow(number);
		}
	}

	private int parseIntOrThrow(int number) {
		return 0;
	}

	private void validNumberRange(int number) {

	}


}

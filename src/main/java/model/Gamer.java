package model;

import java.util.ArrayList;
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
}

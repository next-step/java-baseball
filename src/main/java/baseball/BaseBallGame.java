package baseball;

import java.util.Scanner;

public class BaseBallGame {
	public static final int RESTART_GAME = 1;
	public static final int END_GAME = 2;
	private static final Scanner SCANNER = new Scanner(System.in);
	private Computer computer;
	private Player player;

	public BaseBallGame() {
		this.computer = new Computer();
		this.computer.setNumber(Number.getRandomNumberWithoutDuplicate());
		this.player = new Player();
	}

	private void playerNumberCheck() {
		while (!player.hasNumber()) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = SCANNER.nextLine();
			Number number = validateInput(input);
			player.setNumber(number);
		}
	}

	private Number validateInput(String input) {
		int parseNumber = parseToNumber(input);
		if (parseNumber != -1) {
			return numberValidate(parseNumber);
		}
		return null;
	}

	private int parseToNumber(String input) {
		int returnNumber = -1;
		try {
			returnNumber = Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			System.out.println("숫자가 아닙니다.");
		}
		return returnNumber;
	}

	private Number numberValidate(int parseNumber) {
		Number number = null;
		try {
			number = Number.isValidate(parseNumber);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}
		return number;
	}

	public int gameStart() {
		playerNumberCheck();
		return -1;
	}
}

package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerHelper {
	private static ScannerHelper scannerHelper = new ScannerHelper();
	private Scanner scanner;

	private ScannerHelper() {
		scanner = new Scanner(System.in);
	}

	public static ScannerHelper getInstance() {
		return scannerHelper;
	}

	public List<Integer> getGuess() {
		System.out.print("숫자를 입력해주세요 : ");
		String inputValue = scanner.nextLine();
		final List<Integer> guessList = new ArrayList<>();
		final int length = inputValue.length() > 3 ? 3 : inputValue.length();

		for (int i = 0; i < length; i++) {
			guessList.add(inputValue.charAt(i) - '0');
		}

		return guessList;
	}

	public int getOption() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}
}

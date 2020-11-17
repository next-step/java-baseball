package NumberBaseballGame;

import java.util.Scanner;

public class InputData {

	public int[] getInputDate() {
		Scanner scanner = new Scanner(System.in);
		String scData = "";

		do {
			System.out.print("숫자를 입력하세요 : ");
			scData = scanner.next();
		} while (!isValidInputData(scData));

		return splitInputData(scData);
	}

	public boolean isValidInputData(String scData) {
		if (scData.length() != 3) {
			System.out.println("세자리 숫자를 입력해야합니다");
			return false;
		}
		if (!scData.matches("^[1-9]+$")) {
			System.out.println("1~9 숫자만 입력해야합니다");
			return false;
		}
		if (isDuplicateInput(scData)) {
			System.out.println("중복된 숫자를 입력했습니다");
			return false;
		}
		return true;
	}

	public boolean isDuplicateInput(String scData) {
		String[] scDataToken = scData.split("(?!^)");

		for (int i = 0; i < 3; i++) {
			if (containsCount(scData, scDataToken[i]) > 1) {
				return true;
			}
		}

		return false;
	}

	public int containsCount(String scData, String scDataToken) {
		return scData.length() - scData.replace(scDataToken, "").length();
	}

	public int[] splitInputData(String scData) {
		String[] scDataToken = scData.split("(?!^)");
		int[] inputData = new int[3];

		for (int i = 0; i < 3; i++) {
			inputData[i] = Integer.parseInt(scDataToken[i]);
		}

		return inputData;
	}
}

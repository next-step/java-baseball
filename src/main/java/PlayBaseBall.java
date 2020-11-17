

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PlayBaseBall {

	public static void main(String[] args) {
		int number = getRandomNumber();
		PlayBaseBall playBaseBall = new PlayBaseBall();
		Scanner scan = new Scanner(System.in);

			System.out.println("숫자를 입력해주세요 : ");
			String inputValue = scan.nextLine();

			String message = playBaseBall.verifyInputValue(inputValue);

			if(!message.isEmpty()) {
				System.out.println(message);
			}

			String computerNumber = "";
			if (message.isEmpty()) {
				computerNumber = playBaseBall.getThreeDifferentNumber(number, "");
			}

	}


	public String getThreeDifferentNumber(int number, String resultNumber) {
		int reNumber = getRandomNumber();

		if (resultNumber.length() > 2) {
			return resultNumber;
		}

		if (number < 1) {
			getThreeDifferentNumber(reNumber, resultNumber);
		}

		int index = resultNumber.indexOf(String.valueOf(number));

		if (index > -1) {
			getThreeDifferentNumber(reNumber, resultNumber);
		}

		if (index < 0) {
			resultNumber += number;
		}

		return getThreeDifferentNumber(reNumber, resultNumber);
	}

	public String verifyInputValue(String value) {
		String message = "";
		if (value.isEmpty()) {
			message = "숫자를 입력해 주세요.";
		}
		message = validationValueLength(value);
		message = validationValueIsNumber(value);
		message = validationValueIsZero(value);
		message = validationValueIsDuplication(value);
		return message;
	}

	// 1. 3자리인지 확인
	public String validationValueLength(String value) {
		String message = "";
		if(value.length() != 3) {
			message = "입력한 수가 3자리 인지 확인 해 주세요";
		}
		return message;
	}

	// 2. 숫자인지 확인
	public String validationValueIsNumber(String value) {
		String message = "";
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			message = "입력한 수는 숫자만 입력 가능 합니다.";
		}
		return message;
	}

	// 3. 0인지 확인
	public String validationValueIsZero(String value) {
		String message = "";
		int index = value.indexOf("0");
		if (index > -1) {
			message = "입력한 수는 1에서 9까지 수 입니다.";
		}
		return message;
	}

	// 4. 중복이 없는지 확인
	public String validationValueIsDuplication(String value) {
		String message = "";
		Set resultSet = new HashSet<>();
		for (int i = 0; i < value.length(); i++) {
			resultSet.add(new Character(value.charAt(i)));
		}
		int size = resultSet.size();
		if (size < 3) {
			message = "서로 다른 수를 입력해 주세요.";
		}
		return message;
	}


	public static int getRandomNumber() {
		return (int)(Math.random() * 10); // 0 ~ 9 까지
	}

}

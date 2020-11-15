package exam.baseball;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseBallScanner {
	private static final String PATTERN_INPUT_NUMBER = "^(?!.*(.).*\\1)[1-9]{3}$";
	private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요: ";
	private static final String MESSAGE_WRONG_FORMAT = "잘못된 형식의 입력입니다. "
			+ "입력값은 1부터 9까지 서로 다른 수로 이루어진 3자리 수 입니다."
			+ System.lineSeparator();
	
	private static final Scanner scanner = new Scanner(System.in);

	public static String getBaseBallUserInput() {
		String input = "";
		do {
			printForScanner(MESSAGE_INPUT_NUMBER);
			input = scanner.nextLine(); 
		} while(incorrectBaseballInput(input)); 
		return input;
	}
	
	static boolean incorrectBaseballInput(String input) {
		Pattern pattern = Pattern.compile(PATTERN_INPUT_NUMBER);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return false;
		}
		
		printForScanner(MESSAGE_WRONG_FORMAT);
		return true;
	}
	
	private static void printForScanner(String msg) {
		System.out.print(msg);
	}
	
}

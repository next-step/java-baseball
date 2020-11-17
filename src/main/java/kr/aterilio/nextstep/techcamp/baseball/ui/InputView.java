package kr.aterilio.nextstep.techcamp.baseball.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final String MSG_WELCOME = "=======================================================================\n"
												+ "숫자 야구 게임입니다.\n"
												+ "1-9 까지의 숫자 세개를 입력하여 상대(컴퓨터)가 선정한 숫자 3개를 맞힐 수 있습니다.\n"
												+ "=======================================================================";
	private static final String MSG_STEP_INPUT = "숫자를 입력해주세요 : ";

	private static final String MSG_ERR_FORMAT = "입력된 데이터가 정수가 아닙니다.";
	private static final String MSG_ERR_OUT_OF_RANGE = "허용된 입력 범위를 벗어났습니다.";

	private static final int INPUT_ERROR = -1;
	private static final int INPUT_MIN = 123;
	private static final int INPUT_MAX = 987;

	public void welcome() {
		System.out.println(MSG_WELCOME);
	}

	public List<Integer> trying() {

		int input = INPUT_ERROR;
		System.out.print(MSG_STEP_INPUT);

		try {
			input = scanInt();
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] " + MSG_ERR_FORMAT);
			return getEmptyList();
		}

		if (!isInRange(input)) {
			System.out.println("[ERROR] " + MSG_ERR_OUT_OF_RANGE);
			return getEmptyList();
		}

		return splitInput(input);
	}

	private int scanInt() {
		Scanner scanner = new Scanner(System.in);
		return toInteger(scanner.nextLine());
	}

	private int toInteger(String input) {
		return Integer.parseInt(removeWhitespace(input));
	}

	private String removeWhitespace(String origin) {
		return origin.replaceAll("\\s+", "");
	}

	private boolean isInRange(int input){
		return input >= INPUT_MIN && input <= INPUT_MAX;
	}

	private List<Integer> getEmptyList() {
		return Collections.<Integer>emptyList();
	}

	public static List<Integer> splitInput(int number) {
		ArrayList<Integer> list = new ArrayList<>();
		split(number, list);
		return list;
	}

	private static void split(int number, List<Integer> list) {
		if (number > 10) {
			split(number / 10, list);
		}
		list.add(number % 10);
	}
}

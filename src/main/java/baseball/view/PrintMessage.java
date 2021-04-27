package baseball.view;

public class PrintMessage {

	/*
	 * Show Status
	 */
	public static void printResult(String result) {
		System.out.println(result);
	}

	public static void printStart() {
		System.out.println("게임이 시작되었습니다.");
	}

	public static void printEnd() {
		System.out.println("게임이 종료되었습니다.");
	}

	/*
	 * Ask Question
	 */
	public static void printAskNumber() {
		System.out.println("서로 다른 숫자로 이루어진 3자리 수를 입력하세요.");
	}

	public static void printAskOptionExitOrRestart() {
		System.out.println("게임을 종료하시려면 1, 재시작하시려면 2를 입력하세요.");
	}

	/*
	 * Show Error
	 */
	public static void printErrorThreeDigits() {
		System.out.println("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
	}

	public static void printErrorAllDifferentDigits() {
		System.out.println("중복된 숫자가 포함되어 있습니다.");
	}

	public static void printErrorDigitExistsOnly() {
		System.out.println("1~9 이외의 숫자나 문자가 포함되어 있습니다.");
	}

	public static void printErrorOptionExitOrRestart() {
		System.out.println("종료(1) or 재시작(2)만 입력 가능합니다.");
	}
}

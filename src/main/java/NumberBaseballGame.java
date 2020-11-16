import java.util.Scanner;

public class NumberBaseballGame {

	public final static int RANDOM_DIGIT = 3;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		readyBaseball();

		scanner.close();
	}

	/**
	 * 
	 * 숫자를 입력받아 게임 진행
	 * 
	 * @param randomNum 생성된 랜덤 정수
	 * 
	 */
	private static void readyBaseball() {
		boolean isKeep = true;

		while (isKeep) {
			generateRandomNumDigitException(RANDOM_DIGIT);
			int randomNum = generateRandomNumDigit(RANDOM_DIGIT);

			System.out.println("랜덤 생성된 정수 : " + randomNum); // TODO: 개발 후 삭제

			playBaseball(randomNum);
			isKeep = isKeepGame();
		}
	}

	/**
	 * 
	 * 숫자를 입력받아 게임 진행
	 * 
	 * @param randomNum 생성된 랜덤 정수
	 * 
	 */
	private static void playBaseball(int randomNum) {
		boolean isKeep = true;
		String showMsg = "숫자를 입력해주세요 : ";
		do {
			String inputNumStr = inputNumber(RANDOM_DIGIT, showMsg);
			int inputNum = Integer.parseInt(inputNumStr);
			int strikeCount = countStrike(randomNum, inputNum);
			int ballCount = countBall(randomNum, inputNum) - strikeCount;
			System.out.println(printBaseball(ballCount, strikeCount));
			isKeep = !(isWinGame(strikeCount));
		} while (isKeep);
	}

	/**
	 * 
	 * 1~9까지의 서로 다른 수로 이루어진 digit자리의 수를 생성
	 * 
	 * @param digit 랜덤 생성할 수의 자릿수
	 * @return randomNum 생성된 랜덤 정수
	 * 
	 */
	public static int generateRandomNumDigit(int digit) {
		int randomTmp;
		String randomNum = (int)((Math.random() * 10000) % 9) + 1 + "";

		while (randomNum.length() != digit) { // 입력받은 자릿수가 될 때 까지
			randomTmp = (int)((Math.random() * 10000) % 9) + 1; // 1자리 정수 생성
			randomNum = (randomNum.contains(randomTmp + "")) ? randomNum : randomNum + randomTmp;
		}

		return Integer.parseInt(randomNum);
	}

	/**
	 * 
	 * generateRandomNumDigit 실행시 범위를 벗어날 경우 예외처리 (범위 : 1~9)
	 * 
	 * @param digit 랜덤 생성할 수의 자릿수
	 * 
	 */
	private static void generateRandomNumDigitException(int digit) {

		String message = "랜덤으로 생성되는 자릿수는 1~9까지 입니다.";

		if (digit < 1 || digit > 9) {
			System.out.println(message);
			scanner.close();
			System.exit(0);
		}

	}

	/**
	 * 
	 * ball 카운트 (같은 수가 다른 자리에 있으면 볼)
	 * 
	 * @param randomNum 랜덤정수, inputNum 입력받은 정수
	 * @return ball ball 카운트
	 * 
	 */
	public static int countBall(int randomNum, int inputNum) {
		int ball = 0;
		String[] randomNumArr = (randomNum + "").split("");

		for (String randomNumArrInex : randomNumArr) {
			ball = ((inputNum + "").contains(randomNumArrInex)) ? ball + 1 : ball;
		}

		return ball;
	}

	/**
	 * 
	 * strike 카운트 (같은 수가 같은 자리에 있으면 스트라이크)
	 * 
	 * @param randomNum 랜덤정수, inputNum 입력받은 정수
	 * @return strike strike 카운트
	 * 
	 */
	public static int countStrike(int randomNum, int inputNum) {
		int strike = 0;
		String[] randomNumArr = (randomNum + "").split("");
		String[] inputNumArr = (inputNum + "").split("");

		for (int i = 0; i < randomNumArr.length; i++) {
			strike = (randomNumArr[i].equals(inputNumArr[i])) ? strike + 1 : strike;
		}

		return strike;
	}

	/**
	 * 
	 * 볼 / 스트라이크 / 포볼(낫싱) 출력
	 * 
	 * @param ballCount 볼, strikeCount 스트라이크
	 * @return 카운트 출력값
	 * 
	 */
	private static String printBaseball(int ballCount, int strikeCount) {
		if (ballCount == 0 && strikeCount == 0) {
			return "포볼(낫싱)";
		}
		if (ballCount == 0) {
			return strikeCount + " 스트라이크";
		}
		if (strikeCount == 0) {
			return ballCount + " 볼";
		}
		return strikeCount + " 스트라이크 " + ballCount + " 볼";
	}

	/**
	 * 
	 * 게임 승리 여부 반환 (스트라이크 3)
	 * 
	 * @param strikeCount 스트라이크
	 * @return true(게임승리), false(게임진행중)
	 * 
	 */
	private static boolean isWinGame(int strikeCount) {
		if (strikeCount == 3) {
			System.out.println(RANDOM_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임종료");

			return true;
		}
		return false;
	}

	/**
	 * 
	 * 게임 승리 후 지속 여부
	 * 
	 * @param strikeCount 스트라이크
	 * @return true(게임지속), false(게임종료)
	 * 
	 */
	private static boolean isKeepGame() {
		String showMsg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ";
		String str = inputNumber(1, showMsg);
		return (str.equals("1")) ? true : false;
	}

	/**
	 * 
	 * 숫자 입력받는 메서드
	 * 
	 * @param digit 입력받아야할 숫자 자릿수, showMsg 숫자받을때 출력할 메시지
	 * @return inputNum 입력받은 숫자
	 * 
	 */
	private static String inputNumber(int digit, String showMsg) {
		boolean isCorrect = false;
		String inputNum = "";

		while (!isCorrect) {
			System.out.print(showMsg);
			inputNum = scanner.next();
			isCorrect = inputNumberException(inputNum, digit);
		}

		return inputNum;
	}

	/**
	 * 
	 * 입력받은 숫자 예외처리
	 * 
	 * @param inputNum 입력받은 숫자, digit 입력받아야할 숫자 자릿수
	 * @return true(게임지속), false(게임종료)
	 * 
	 */
	private static boolean inputNumberException(String inputNum, int digit) {
		if (!inputNumberIntegerException(inputNum) || !inputNumberZeroException(inputNum)
			|| !inputNumberLengthException(inputNum, digit)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 입력받은 문자가 정수인지 체크
	 * 
	 * @param inputNum 입력받은 문자
	 * @return true (정상), false(비정상)
	 * 
	 */
	private static boolean inputNumberIntegerException(String inputNum) {
		try {
			Integer.parseInt(inputNum);
		} catch (NumberFormatException e) {
			System.out.println("양의 정수만 입력가능합니다.");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 입력받은 문자에 0이 포함되어 있는지 체크
	 * 
	 * @param inputNum 입력받은 문자
	 * @return true (정상), false(비정상)
	 * 
	 */
	private static boolean inputNumberZeroException(String inputNum) {
		if (inputNum.contains("0")) {
			System.out.println("0이아닌 양의 정수만 입력가능합니다.");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 입력받은 문자 자릿수가 맞는지 체크
	 * 
	 * @param inputNum 입력받은 문자, digit (입력받아야할 정수자릿수)
	 * @return true (정상), false(비정상)
	 * 
	 */
	private static boolean inputNumberLengthException(String inputNum, int digit) {
		if (inputNum.length() != digit) {
			System.out.println("입력문자의 자릿수를 확인해주세요.");
			return false;
		}
		return true;
	}

}

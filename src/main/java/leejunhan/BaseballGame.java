package leejunhan;

import java.util.Random;
import java.util.Scanner;

/**
 * 숫자 야구 게임
 *
 * @author 이준한
 * @version 0.8
 * @since 2020-11-14
 */
public class BaseballGame {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		gameStart();
	}

	/**
	 * 숫자 야구 게임 시작.
	 */
	public static void gameStart() {
		String baseballNumber = getBaseballNumber();
		System.out.println("baseballNumber = " + baseballNumber);
		challenge(baseballNumber);
		gameExitDecision();
	}

	/**
	 * 야구게임용 3자리 숫자 리턴.
	 *
	 * @return the baseball number
	 */
	public static String getBaseballNumber() {
		int[] randomNumberArray = new int[3];
		for (int i = 0; i < 3; i++) {
			randomNumberArray[i] = (getOneRandomNumber(randomNumberArray));
		}
		return getIntArrayToString(randomNumberArray);
	}

	/**
	 * int배열을 String으로 변환
	 *
	 * @param randomNumberArray 변환할 int배열
	 * @return the int array to string
	 */
	public static String getIntArrayToString(int[] randomNumberArray) {
		String baseballNumber = "";
		for (int number : randomNumberArray) {
			baseballNumber += String.valueOf(number);
		}
		return baseballNumber;
	}

	/**
	 * 중복체크한 랜덤 숫자 리턴.
	 *
	 * @param randomNumberArray 랜덤숫자배열. 이미 생성한 숫자와의 중복 체크를 위한 parameter
	 * @return the one random number
	 */
	public static int getOneRandomNumber(int[] randomNumberArray) {
		int randomNumber = getRandomNumberRangeOneToNine();
		if (duplicateFlag(randomNumberArray[0], randomNumber)
			|| duplicateFlag(randomNumberArray[1], randomNumber)) {
			return getOneRandomNumber(randomNumberArray);
		}
		return randomNumber;
	}

	/**
	 * 1~9 랜덤숫자 리턴.
	 *
	 * @return the random number range one to nine
	 */
	public static int getRandomNumberRangeOneToNine() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}

	/**
	 * 숫자 중복 체크 (중복일 경우 true 리턴).
	 *
	 * @param standardNumber 기존에 생성된 랜덤숫자
	 * @param randomNumber   새로 생성한 랜덤숫자
	 * @return the boolean
	 */
	public static boolean duplicateFlag(int standardNumber, int randomNumber) {
		if (standardNumber == randomNumber) {
			return true;
		}
		return false;
	}

	/**
	 * 숫자를 입력받아 결과 출력.
	 *
	 * @param baseballNumber 컴퓨터가 생성한 3자리 야구게임 숫자
	 */
	public static void challenge(String baseballNumber) {
		String inputNumber = getInputString("숫자를 입력해주세요 : ");
		int strikeCount = getStrike(baseballNumber, inputNumber);;
		int ballCount = getBall(baseballNumber, inputNumber) - strikeCount;
		String challengeResult = getChallengeResult(strikeCount, ballCount);
		System.out.println(challengeResult);
		if (strikeCount < 3) {
			challenge(baseballNumber);
		}
	}

	/**
	 * 사용자 문자입력.
	 *
	 * @param prefix 문자 입력 전 출력할 문구
	 * @return the input string
	 */
	public static String getInputString(String prefix) {
		System.out.print(prefix);
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine().trim();
		return inputString;
	}

	/**
	 * 스트라이크 개수 조회.
	 *
	 * @param baseballNumber 컴퓨터가 생성한 3자리 야구게임 숫자
	 * @param inputNumber    사용자에게 입력받은 3자리 숫자
	 * @return the strike
	 */
	public static int getStrike(String baseballNumber, String inputNumber) {
		int strike = 0;
		strike += strikeCount(baseballNumber.charAt(0), inputNumber.charAt(0));
		strike += strikeCount(baseballNumber.charAt(1), inputNumber.charAt(1));
		strike += strikeCount(baseballNumber.charAt(2), inputNumber.charAt(2));
		return strike;
	}

	/**
	 * 두개의 숫자를 비교하여 같을 경우 1 (strike), 다를 경우 0을 리턴.
	 *
	 * @param baseballNumberChar 컴퓨터가 생성한 3자리 야구게임 숫자 중 비교할 숫자 한자리
	 * @param inputNumberChar    사용자에게 입력받은 3자리 숫자 중 비교할 숫자 한자리
	 * @return the int
	 */
	public static int strikeCount(char baseballNumberChar, char inputNumberChar) {
		if (baseballNumberChar == inputNumberChar) {
			return 1;
		}
		return 0;
	}

	/**
	 * 볼 개수 조회.
	 *
	 * @param baseballNumber 컴퓨터가 생성한 3자리 야구게임 숫자
	 * @param inputNumber    사용자에게 입력받은 3자리 숫자
	 * @return the ball
	 */
	public static int getBall(String baseballNumber, String inputNumber) {
		int ball = 0;
		ball += ballCount(baseballNumber, inputNumber.substring(0, 1));
		ball += ballCount(baseballNumber, inputNumber.substring(1, 2));
		ball += ballCount(baseballNumber, inputNumber.substring(2, 3));
		return ball;
	}

	/**
	 * 숫자를 비교하여 같을 경우 1 (ball), 다를 경우 0을 리턴.
	 *
	 * @param baseballNumber 컴퓨터가 생성한 3자리 야구게임 숫자
	 * @param inputNumber    사용자에게 입력받은 3자리 숫자 중 비교할 숫자 한자리
	 * @return the int
	 */
	public static int ballCount(String baseballNumber, String inputNumber) {
		if (baseballNumber.contains(inputNumber)) {
			return 1;
		}
		return 0;
	}

	/**
	 * 입력 결과 (게임 결과) 메시지 조회.
	 *
	 * @param strikeCount strike 개수
	 * @param ballCount   ball 개수
	 * @return the challenge result
	 */
	public static String getChallengeResult(int strikeCount, int ballCount) {
		if (strikeCount > 0 && ballCount > 0) {
			return strikeCount + " 스트라이크 " + ballCount + "볼";
		}
		if (strikeCount > 0) {
			return strikeCount + " 스트라이크";
		}
		if (ballCount > 0) {
			return ballCount + "볼";
		}
		return "낫싱";
	}

	/**
	 * 게임 성공 후 종료 여부 결정
	 */
	public static void gameExitDecision() {
		String inputExitFlagNumber = getInputString("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
			+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요\n");
		if (!"1".equals(inputExitFlagNumber) && !"2".equals(inputExitFlagNumber)) {
			System.out.println("1 또는 2 만 입력 가능합니다.");
			gameExitDecision();
		}
		if ("1".equals(inputExitFlagNumber)) {
			gameStart();
		}
	}

}

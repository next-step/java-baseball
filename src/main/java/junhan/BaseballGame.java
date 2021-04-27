package junhan;

import java.util.Random;
import java.util.Scanner;

/**
 * 숫자 야구 게임
 *
 * @author 이준한
 * @since 2021-04-26
 */
public class BaseballGame {

	private static Random random = new Random();

	/**
	 * 숫자 야구 게임.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		gameStart();
	}

	private static void gameStart() {
		String baseballNumber = getBaseballNumber();
		challenge(baseballNumber);
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		String inputExitFlagNumber = getInputString("");
		if ("1".equals(inputExitFlagNumber)) {
			gameStart();
		}
	}

	/**
	 * 숫자를 입력받아 결과 출력.
	 *
	 * @param baseballNumber 컴퓨터가 생성한 3자리 야구게임 숫자
	 */
	public static void challenge(String baseballNumber) {
		String inputNumber = getInputString("숫자를 입력해주세요 : ");
		//TODO 입력값 체크 구현
		System.out.println("3 스트라이크");
	}

	/**
	 * 문자입력.
	 *
	 * @param prefix 문자 입력 전 출력할 문구
	 * @return the input string
	 */
	public static String getInputString(String prefix) {
		System.out.print(prefix);
		Scanner in = new Scanner(System.in);
		return in.nextLine().trim();
	}

	/**
	 * 야구게임용 3자리 숫자 리턴.
	 *
	 * @return 3 digit number
	 */
	static String getBaseballNumber() {
		int[] randomNumberArray = new int[3];
		for (int i = 0; i < 3; i++) {
			randomNumberArray[i] = (getOneRandomNumber(randomNumberArray));
		}
		return getIntArrayToString(randomNumberArray);
	}

	/**
	 * 중복체크한 랜덤 숫자 리턴.
	 *
	 * @param randomNumberArray 랜덤숫자배열. 이미 생성한 숫자와의 중복 체크를 위한 parameter
	 * @return the one random number
	 */
	static int getOneRandomNumber(int[] randomNumberArray) {
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
	static int getRandomNumberRangeOneToNine() {
		return random.nextInt(9) + 1;
	}

	/**
	 * 숫자 중복 체크 (중복일 경우 true 리턴).
	 *
	 * @param standardNumber 기존에 생성된 랜덤숫자
	 * @param randomNumber   새로 생성한 랜덤숫자
	 * @return the boolean
	 */
	static boolean duplicateFlag(int standardNumber, int randomNumber) {
		return (standardNumber == randomNumber);
	}

	/**
	 * int배열을 String으로 변환
	 *
	 * @param randomNumberArray 변환할 int배열
	 * @return the int array to string
	 */
	static String getIntArrayToString(int[] randomNumberArray) {
		StringBuilder baseballNumber = new StringBuilder();
		for (int number : randomNumberArray) {
			baseballNumber.append(number);
		}
		return baseballNumber.toString();
	}
}

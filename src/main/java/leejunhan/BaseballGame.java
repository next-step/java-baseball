package leejunhan;

import java.util.Random;

/**
 * 숫자 야구 게임
 *
 * @author 이준한
 * @version 1.0
 * <pre>
 * 2020.11.14 : 최초 작성
 * </pre>
 * @since 2020-11-14
 */
public class BaseballGame {

	/**
	 * 숫자 야구 게임.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		System.out.println("숫자를 입력해주세요 : 123");
		String inputNumber = "123"; // TODO: 입력 구현

		String baseballNumber = getBaseballNumber();
		System.out.println(baseballNumber);

		// TODO: 입력값 체크 로직 생성

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
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

}

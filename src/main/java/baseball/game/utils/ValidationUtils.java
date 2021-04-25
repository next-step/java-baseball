/*
 * @(#) ValidationUtils.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.utils;

/**
 * @author 박준영
 */
public class ValidationUtils {

	/**
	 * 입력한 문자가 숫자인지 유효성 체크
	 * @param input
	 * @return
	 */
	public static boolean isValidNumber(String input) {
		String regExp = "^[0-9]*$";
		return input.matches(regExp);
	}
}

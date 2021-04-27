import java.util.Random;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * @fileName        : BaseballCalculator.java
 * @author          : Sunghwa Lee
 * @description     : Class in charge of main logic of the game
 */
public class BaseballCalculator {

	/**
	 * @methodName  : getRandomAnswer
	 * @author      : Sunghwa Lee
	 * @description : Return a randomly generated answer
	 * @param maxDigit Max digit count of answer.
	 * @return Answer string
	 */
	public static String getRandomAnswer(@Range(from = 1, to = 9) int maxDigit) {
		String result = "";
		for (int i = 0; i < maxDigit; i++) {
			result += getRandomNumber(result);
		}
		return result;
	}

	/**
	 * @methodName  : getRandomNumber
	 * @author      : Sunghwa Lee
	 * @description : Return a randomly generated non-duplicate number string
	 * @param existingNumber Existing number string for checking duplicate number
	 * @return Randomly generated number to string
	 */
	private static String getRandomNumber(@NotNull String existingNumber) {
		final int maxNumber = 10;
		Random random = new Random();
		String result;
		do {
			result = Integer.toString(random.nextInt(maxNumber));
		} while (result.equals("0") || existingNumber.contains(result));
		return result;
	}

	/**
	 * @methodName  : getStrikeCount
	 * @author      : Sunghwa Lee
	 * @description : Compare the answer with the input and return the number of strikes
	 * @param answer Answer string
	 * @param input User input string
	 * @return Count of strikes
	 */
	public static int getStrikeCount(String answer, String input) {
		int result = 0;
		for (int i = 0; i < answer.length(); i++) {
			result += isStrike(answer.charAt(i), input.charAt(i));
		}
		return result;
	}

	/**
	 * @methodName  : isStrike
	 * @author      : Sunghwa Lee
	 * @description : Compare the answer with the input and return whether or not strike
	 * @param answer Answer character
	 * @param input User input character
	 * @return If the input is strike, return 1 otherwise return 0
	 */
	private static int isStrike(char answer, char input) {
		if (answer == input) {
			return 1;
		}
		return 0;
	}

	/**
	 * @methodName  : getBallCount
	 * @author      : Sunghwa Lee
	 * @description : Compare the answer with the input and return the number of balls
	 * @param answer Answer string
	 * @param input User input string
	 * @return Count of balls
	 */
	public static int getBallCount(String answer, String input) {
		int result = 0;
		for (int i = 0; i < answer.length(); i++) {
			result += isBall(answer, input.charAt(i), i);
		}
		return result;
	}

	/**
	 * @methodName  : isBall
	 * @author      : Sunghwa Lee
	 * @description : Compare the answer with the input and return whether or not ball
	 * @param answer Answer string
	 * @param input User input character
	 * @param position Position of character
	 * @return If the input is ball, return 1 otherwise return 0
	 */
	private static int isBall(String answer, char input, int position) {
		if (answer.charAt(position) != input && answer.contains(String.valueOf(input))) {
			return 1;
		}
		return 0;
	}
}

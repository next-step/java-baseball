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
}

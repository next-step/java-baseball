/*
 * @(#) NumberUtils.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.utils;

import java.util.Random;

/**
 * @author 박준영
 */
public class NumberUtils {

	public static int getGeneratedRandomNumbers(int min, int max) {
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		int randomNumber = random.nextInt(min) + max;

		return randomNumber;
	}
}

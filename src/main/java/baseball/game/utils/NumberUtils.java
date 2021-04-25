/*
 * @(#) NumberUtils.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.utils;

import java.util.List;
import java.util.Random;

/**
 * @author 박준영
 */
public class NumberUtils {

	/**
	 * 랜덤 숫자(min ~ max) 반환
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getGeneratedRandomNumber(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt(max) + min;

		return randomNumber;
	}

	/**
	 * 중복되지 않은 숫자 리스트를 반환
	 * @param selectedNumberList
	 * @param generatedRandomNumber
	 * @return
	 */
	public static List<Integer> selectNumbersNotDuplicate(List<Integer> selectedNumberList, int generatedRandomNumber) {
		if (!selectedNumberList.contains(generatedRandomNumber)) {
			selectedNumberList.add(generatedRandomNumber);
		}

		return selectedNumberList;
	}
}

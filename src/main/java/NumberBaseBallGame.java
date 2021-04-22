import java.util.Arrays;
import java.util.Collections;

public class NumberBaseBallGame {

	public static int[] numberBaseballGameGenerate() {
		Integer[] baseNumbers = {1,2,3,4,5,6,7,8,9};
		Collections.shuffle(Arrays.asList(baseNumbers));
		Integer[] pickNumbers = Arrays.copyOfRange(baseNumbers, 0,2);

		int[] gameNumbers = new int[3];
		for(int i = 0; i < gameNumbers.length - 1; i ++) {
			gameNumbers[i] = pickNumbers[i];
		}
		return gameNumbers;
	}
}

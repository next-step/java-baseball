import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumberBaseBallGame {

	public static int[] numberBaseballGameGenerate() {
		Integer[] baseNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Collections.shuffle(Arrays.asList(baseNumbers));
		Integer[] pickNumbers = Arrays.copyOfRange(baseNumbers, 0, 2);

		int[] gameNumbers = new int[3];
		for (int i = 0; i < gameNumbers.length - 1; i++) {
			gameNumbers[i] = pickNumbers[i];
		}
		return gameNumbers;
	}

	public static boolean playerNumberValidate(int[] playerInputNumbers) {
		if (playerInputNumbers.length < 3)
			return false;

		Set<Integer> duplicateRemovedGameNumbers = new HashSet<>();
		for (int playerInputNumber : playerInputNumbers) {
			duplicateRemovedGameNumbers.add(playerInputNumber);
		}

		if (duplicateRemovedGameNumbers.size() < 3)
			return false;

		return true;
	}

	public static int[] playerInputNumbersToArray(int playerInput) {
		String numbers = String.valueOf(playerInput);
		int[] playerInputNumbers = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			playerInputNumbers[i] = Integer.parseInt(numbers.substring(i, i + 1));
		}
		return playerInputNumbers;
	}
}

package baseball;

import java.util.Arrays;
import java.util.Random;

import baseball.util.GameStatus;

public class BaseballNumberGenerator {

	public static Baseball CreateNumber() {
		int[] randomArray = new int[GameStatus.BALL_SIZE];
		for (int i = 0; i < GameStatus.BALL_SIZE; i++) {
			randomArray[i] = createRandomNumber(randomArray);
		}
		System.out.println(Arrays.toString(randomArray));
		return new Baseball(randomArray);
	}

	public static int createRandomNumber(int[] randomArray) {
		Random random = new Random();
		int randomNumber;
		do {
			randomNumber = random.nextInt(GameStatus.BALL_RANGE) + 1;
		} while (ContainsChecker.isContains(randomArray, randomNumber));
		return randomNumber;
	}

}

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import data.BaseballNumbers;

public class NumberGenerator {
	public static final int GENERATE_NUMBER_LENGTH = 9;
	public static final int GENERATE_NUMBER_MIN = 1;
	public static final int BALL_NUMBER_LENGTH = 3;

	private Random random;

	public NumberGenerator() {
		this.random = new Random();
	}

	public BaseballNumbers generateBaseballNumbers() {
		Set<Integer> numberSet = new LinkedHashSet<>(); //순서 보장
		while(numberSet.size() < BALL_NUMBER_LENGTH) {
			numberSet.add(random.nextInt(GENERATE_NUMBER_LENGTH) + GENERATE_NUMBER_MIN);
		}
		return new BaseballNumbers(numberSet);
	}
}

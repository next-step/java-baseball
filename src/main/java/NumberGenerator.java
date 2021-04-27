import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import constant.BaseballGameCondition;
import data.BaseballNumbers;

public class NumberGenerator {

	private Random random;

	public NumberGenerator() {
		this.random = new Random();
	}

	public BaseballNumbers generateBaseballNumbers() {
		Set<Integer> numberSet = new LinkedHashSet<>(); //순서 보장
		while(numberSet.size() < BaseballGameCondition.BALL_NUMBER_LENGTH) {
			numberSet.add(random.nextInt(BaseballGameCondition.GENERATE_NUMBER_LENGTH) + BaseballGameCondition.GENERATE_NUMBER_MIN);
		}
		return new BaseballNumbers(numberSet);
	}
}

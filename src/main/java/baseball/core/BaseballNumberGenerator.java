/**
* FileName : BaseballNumberServiceImpl.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball number service 구현체
*/
package baseball.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import baseball.model.BaseballNumber;
import baseball.model.RandomBaseballNumber;

public class BaseballNumberGenerator {

	/** random index max bound */
	private static final int INDEX_MAX_BOUND = 9;

	/** 1~9 까지의 선택가능한 숫자를 저장 */
	private final List<Integer> baseballNumbers = new ArrayList<>();

	public BaseballNumberGenerator() {
		this.initBaseballNumbers();
	}

	/**
	 * 컴퓨터의 1~9까지 숫자중 임의의 서로다른 3자리 숫자를 반환합니다.
	 * 
	 * @return BaseballRandomNumber
	 */
	public BaseballNumber getRandomBaseballNumber() {

		int first = this.baseballNumbers.remove(this.getRandomIndex(INDEX_MAX_BOUND));
		int second = this.baseballNumbers.remove(this.getRandomIndex(INDEX_MAX_BOUND - 1));
		int third = this.baseballNumbers.remove(this.getRandomIndex(INDEX_MAX_BOUND - 2));

		RandomBaseballNumber randomBaseballNumber = new RandomBaseballNumber();
		randomBaseballNumber.addNumber(first);
		randomBaseballNumber.addNumber(second);
		randomBaseballNumber.addNumber(third);

		return randomBaseballNumber;
	}

	private void initBaseballNumbers() {
		for (int i = 1; i < 10; i++) {
			this.baseballNumbers.add(i);
		}
	}

	private int getRandomIndex(int bound) {
		return ThreadLocalRandom.current().nextInt(bound);
	}

}

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

	/**
	 * BaseballNumberServiceImpl 클래스의 새 인스턴스를 초기화 합니다.
	 */
	public BaseballNumberGenerator() {
		this.initBaseballNumbers();
	}

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

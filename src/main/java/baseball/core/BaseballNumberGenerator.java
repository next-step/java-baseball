/**
* FileName : BaseballNumberServiceImpl.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball number service 구현체
*/
package baseball.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.model.BaseballNumber;

public class BaseballNumberGenerator {

	/** 1~9 까지의 선택가능한 숫자를 저장 */
	private final List<Integer> baseballNumbers = new ArrayList<>();

	private BaseballNumberGenerator() {
		this.initBaseballNumbers();
	}

	public static BaseballNumberGenerator getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * 컴퓨터의 1~9까지 숫자중 임의의 서로다른 3자리 숫자를 반환합니다.
	 * 
	 * @return BaseballRandomNumber
	 */
	public BaseballNumber getRandomBaseballNumber() {

		List<Integer> extractNumbers = this.getRandomNumberList();

		BaseballNumber randomBaseballNumber = new BaseballNumber();
		for (int i = 0; i < extractNumbers.size(); i++) {
			randomBaseballNumber.addNumber(extractNumbers.get(i));
		}
		return randomBaseballNumber;
	}

	private List<Integer> getRandomNumberList() {
		Collections.shuffle(this.baseballNumbers);
		return this.baseballNumbers.subList(0, 3);
	}

	private void initBaseballNumbers() {
		for (int i = 1; i < 10; i++) {
			this.baseballNumbers.add(i);
		}
	}

	private static class LazyHolder {
		private static final BaseballNumberGenerator INSTANCE = new BaseballNumberGenerator();
	}

}

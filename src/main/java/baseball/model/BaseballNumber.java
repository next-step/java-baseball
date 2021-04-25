/**
* FileName : RandomNumber.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : random baseball number model
*/
package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {

	private final List<Integer> numbers = new ArrayList<>();

	public void addNumber(int number) {
		this.numbers.add(number);
	}

	/**
	 * numbers를 반환합니다.
	 * 
	 * @return numbers
	 */
	public List<Integer> getNumbers() {
		return this.numbers;
	}

}

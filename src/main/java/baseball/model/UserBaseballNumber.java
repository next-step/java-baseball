/**
* FileName : UserBaseballNumber.java
* Created  : 2021. 4. 26.
* Author   : youngjun.jin
* Summary  : 사용자 입력을 통해 생성하는 BaseballNumber
*/
package baseball.model;

import baseball.exception.BaseballException;

public class UserBaseballNumber extends BaseballNumber {
	private static final String NUMERIC_REGEX = "^[1-9][1-9][1-9]$";

	public UserBaseballNumber(String userInput) {
		if (userInput.matches(NUMERIC_REGEX) == false) {
			throw new BaseballException("1~9 범위의 세자리 숫자를 입력하세요.");
		}
		int inputNumber = Integer.parseInt(userInput);

		int first = inputNumber / 100;
		int second = inputNumber % 100 / 10;
		int third = inputNumber % 10;

		this.addNumber(first);
		this.addNumber(second);
		this.addNumber(third);
	}

}

/**
* FileName : UserBaseballNumber.java
* Created  : 2021. 4. 26.
* Author   : youngjun.jin
* Summary  : 사용자 입력을 통해 생성하는 BaseballNumber
*/
package baseball.model;

public class UserBaseballNumber extends BaseballNumber {

	/**
	 * UserBaseballNumber 클래스의 새 인스턴스를 초기화 합니다.
	 */
	public UserBaseballNumber(String userInput) {

		// TODO input validation
		int inputNumber = Integer.parseInt(userInput);

		int first = inputNumber / 100;
		int second = inputNumber % 100 / 10;
		int third = inputNumber % 10;

		this.addNumber(first);
		this.addNumber(second);
		this.addNumber(third);
	}

}

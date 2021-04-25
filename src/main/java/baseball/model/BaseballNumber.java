/**
* FileName : RandomNumber.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : random baseball number model
*/
package baseball.model;

public class BaseballNumber {

	private final int firstNumber;
	private final int secondNumber;
	private final int thirdNumber;

	/**
	 * BaseballNumber 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @param firstNumber  첫번째 수
	 * @param secondNumber 두번째 수
	 * @param thirdNumber  세번째 수
	 */
	public BaseballNumber(int firstNumber, int secondNumber, int thirdNumber) {
		super();
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.thirdNumber = thirdNumber;
	}

	/**
	 * firstNumber를 반환합니다.
	 * 
	 * @return firstNumber
	 */
	public int getFirstNumber() {
		return this.firstNumber;
	}

	/**
	 * secondNumber를 반환합니다.
	 * 
	 * @return secondNumber
	 */
	public int getSecondNumber() {
		return this.secondNumber;
	}

	/**
	 * thirdNumber를 반환합니다.
	 * 
	 * @return thirdNumber
	 */
	public int getThirdNumber() {
		return this.thirdNumber;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 * @author youngjun.jin
	 */
	@Override
	public String toString() {
		return "BaseballNumber [firstNumber=" + firstNumber + ", secondNumber=" + secondNumber + ", thirdNumber="
				+ thirdNumber + "]";
	}

}

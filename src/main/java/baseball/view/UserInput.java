/**
* FileName : UserInput.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 입력 singleton
*/
package baseball.view;

import java.util.Scanner;

public class UserInput {

	/** Scanner instance */
	private Scanner scanner;

	/** userInput singleton instance */
	private static UserInput instance = null;

	/**
	 * UserInput 클래스의 새 인스턴스를 초기화 합니다.
	 */
	private UserInput() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * UserInput instance를 반환합니다.
	 * 
	 * @return userInput
	 */
	public static UserInput getInstance() {
		if (instance == null) {
			instance = new UserInput();
		}
		return instance;
	}

	/**
	 * 사용자 입력을 수행합니다.
	 * 
	 * @return 사용자 입력값
	 */
	public String input() {
		return this.scanner.nextLine();
	}

	/**
	 * scanner 를 close합니다.
	 */
	public void closeScanner() {
		this.scanner.close();
	}

}

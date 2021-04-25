/**
* FileName : UserInput.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 입력 singleton
*/
package baseball.view;

import java.util.Scanner;

public class InputView extends View {

	private final Scanner scanner;

	/**
	 * UserInput 클래스의 새 인스턴스를 초기화 합니다.
	 */
	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * 숫자 입력 input 생성
	 * 
	 * @return 입력값
	 */
	public String getMakeNumberInput() {
		out.print("숫자를 입력해주세요 : ");
		return this.scanner.nextLine();
	}

	/**
	 * 게임을 계속진행할지 여부 입력 생성
	 * 
	 * @return 입력값
	 */
	public String getMakeContinueInput() {
		out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return this.scanner.nextLine();
	}

	public void closeUserInput() {
		this.scanner.close();
	}
}

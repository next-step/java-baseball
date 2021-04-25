/**
* FileName : InputView.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 콘솔 입력 클래스
*/
package baseball.view;

import java.util.Scanner;

public class InputView extends View {

	private final Scanner scanner;

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
		out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return this.scanner.nextLine();
	}

	public void closeUserInput() {
		this.scanner.close();
	}
}

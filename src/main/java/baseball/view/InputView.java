/**
* FileName : InputView.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 콘솔 입력 클래스
*/
package baseball.view;

import java.util.Scanner;

public class InputView extends View {

	private static final String SELECT_MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public void closeUserInput() {
		this.scanner.close();
	}

	/**
	 * 게임을 계속진행할지 여부 입력 생성
	 * 
	 * @return 입력값
	 */
	public String getMakeContinueInput() {
		out.println(SELECT_MENU_MESSAGE);
		return this.scanner.nextLine();
	}

	/**
	 * 숫자 입력 input 생성
	 * 
	 * @return 입력값
	 */
	public String getMakeNumberInput() {
		out.print(INPUT_NUMBER_MESSAGE);
		return this.scanner.nextLine();
	}
}

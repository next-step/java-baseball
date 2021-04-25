/**
* FileName : BaseballGameExecutor.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball game 실행 클래스
*/
package baseball.core;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameExecutor {

	private final InputView userInput;

	private final OutputView userOutput;

	/**
	 * BaseballGameExecutor 클래스의 새 인스턴스를 초기화 합니다.
	 */
	public BaseballGameExecutor() {
		this.userInput = new InputView();
		this.userOutput = new OutputView();
	}

	/**
	 * 야구 게임을 실행합니다.
	 */
	public void execute() {

		boolean isEnd = false;

		while (!isEnd) {

			BaseballGame baseballGame = new BaseballGame(this.userInput, this.userOutput);
			baseballGame.startGame();

			isEnd = this.checkContinueGame();
		}

		this.userInput.closeUserInput();
	}

	private boolean checkContinueGame() {
		String continueInput = this.userInput.getMakeContinueInput();

		if ("1".equals(continueInput)) {
			return false;
		}

		return true;
	}
}

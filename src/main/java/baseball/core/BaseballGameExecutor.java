/**
* FileName : BaseballGameExecutor.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball game 실행 클래스
*/
package baseball.core;

import baseball.exception.BaseballException;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameExecutor {

	private static final String MENU_REGEX = "^[1-2]$";

	private final InputView userInput;

	private final OutputView userOutput;

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

		if (continueInput.matches(MENU_REGEX) == false) {
			throw new BaseballException("1 or 2만 입력가능합니다.");
		}

		if ("1".equals(continueInput)) {
			return false;
		}

		return true;
	}
}

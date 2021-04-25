/**
* FileName : BaseballGameExecutor.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball game 실행 클래스
*/
package baseball.core;

import baseball.view.UserInput;

public class BaseballGameExecutor {

	/**
	 * 야구 게임을 실행합니다.
	 */
	public void execute() {

		boolean isEnd = false;

		while (!isEnd) {

			BaseballGame baseballGame = new BaseballGame();
			baseballGame.startGame();

			isEnd = this.checkContinueGame();
		}
	}

	private boolean checkContinueGame() {
		// TODO game 지속 여부 확인구현
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

		UserInput userInput = UserInput.getInstance();
		String input = userInput.input();

		if ("1".equals(input)) {
			return false;
		}

		return true;
	}
}

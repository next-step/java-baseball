/**
* FileName : OutputView.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : console output view 클래스
*/
package baseball.view;

import baseball.model.InningResult;

public class OutputView extends View {

	private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

	public void printEndGame() {
		out.println(END_GAME_MESSAGE);
	}

	public void printInningResult(InningResult inningResult) {
		out.println(inningResult.toString());
	}
}

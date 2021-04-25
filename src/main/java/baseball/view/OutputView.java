/**
* FileName : OutputView.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : console output view 클래스
*/
package baseball.view;

import baseball.model.InningResult;

public class OutputView extends View {

	public void printInningResult(InningResult inningResult) {
		out.println(inningResult.toString());
	}

	public void printEndGame() {
		out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
}

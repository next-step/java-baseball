/**
* FileName : OutputView.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : console output view 클래스
*/
package baseball.view;

import java.util.StringJoiner;

import baseball.model.InningResult;

public class OutputView extends View {

	private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

	public void printEndGame() {
		out.println(END_GAME_MESSAGE);
	}

	public void printInningResult(InningResult inningResult) {
		StringJoiner joiner = new StringJoiner(" ");

		int ball = inningResult.getBall();
		int strike = inningResult.getStrike();

		if (strike == 0 && ball == 0) {
			out.println(joiner.add("nothing").toString());
			return;
		}

		this.printStrikeCount(joiner, strike);
		this.printBallCount(joiner, ball);

		out.println(inningResult.toString());
	}

	private void printBallCount(StringJoiner joiner, int ball) {
		if (ball > 0) {
			joiner.add(String.valueOf(ball)).add("볼");
		}
	}

	private void printStrikeCount(StringJoiner joiner, int strike) {
		if (strike > 0) {
			joiner.add(String.valueOf(strike)).add("스트라이크");
		}
	}
}

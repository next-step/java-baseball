/**
* FileName : BaseballGame.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball game 1세트를 수행하기위한 클래스
*/
package baseball.core;

import baseball.model.BaseballNumber;
import baseball.model.InningResult;
import baseball.model.UserBaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

	private final BaseballNumberGenerator baseballNumberGenerator;

	private final BaseballNumber randomBaseballNumber;

	private final InputView inputView;

	private final OutputView outputView;

	public BaseballGame(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;

		this.baseballNumberGenerator = new BaseballNumberGenerator();
		this.randomBaseballNumber = this.baseballNumberGenerator.getRandomBaseballNumber();
	}

	/**
	 * 3스트라이크가 나와 이닝이 종료될때까지 한 세트의 야구게임을 진행합니다.
	 */
	public void startGame() {

		boolean isEnd = false;
		while (!isEnd) {
			String inputValue = this.inputView.getMakeNumberInput();

			UserBaseballNumber userBaseballNumber = new UserBaseballNumber(inputValue);
			InningResult inningResult = new InningResult();

			inningResult.judgeInningResult(this.randomBaseballNumber, userBaseballNumber);

			this.outputView.printInningResult(inningResult);
			isEnd = inningResult.isEndGame();
		}

		this.outputView.printEndGame();
	}
}

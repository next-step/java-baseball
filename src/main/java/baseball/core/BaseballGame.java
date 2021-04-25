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

	/**
	 * BaseballGame 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @param inputView  user input instance
	 * @param outputView user output instance
	 */
	public BaseballGame(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;

		this.baseballNumberGenerator = new BaseballNumberGenerator();
		this.randomBaseballNumber = this.baseballNumberGenerator.getRandomBaseballNumber();
	}

	public void startGame() {

		boolean isEnd = false;
		while (!isEnd) {
			String inputValue = this.inputView.getMakeNumberInput();

			UserBaseballNumber userBaseballNumber = new UserBaseballNumber(inputValue);
			InningResult inningResult = new InningResult(0, 0);

			inningResult.judgeInningResult(this.randomBaseballNumber, userBaseballNumber);

			this.outputView.printInningResult(inningResult);
			isEnd = inningResult.isEndGame();
		}

		this.outputView.printEndGame();
	}
}

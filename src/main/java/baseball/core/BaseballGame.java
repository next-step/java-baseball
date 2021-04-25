/**
* FileName : BaseballGame.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball game 1세트를 수행하기위한 클래스
*/
package baseball.core;

import baseball.model.BaseballNumber;
import baseball.model.InningResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

	private final BaseballNumberGenerator baseballNumberGenerator;

	private final BaseballInningService baseballInningService;

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
		BaseballNumber randomBaseballNumber = this.baseballNumberGenerator.getRandomBaseballNumber();
		this.baseballInningService = new BaseballInningServiceImpl(randomBaseballNumber);
	}

	public void startGame() {

		boolean isEnd = false;
		while (!isEnd) {
			String inputValue = this.inputView.getMakeNumberInput();

			InningResult judgeInning = this.baseballInningService.judgeInning(inputValue);
			this.outputView.printInningResult(judgeInning);
			isEnd = this.baseballInningService.isEndGame(judgeInning);
		}

		this.outputView.printEndGame();
	}
}

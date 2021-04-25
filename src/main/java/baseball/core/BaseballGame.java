/**
* FileName : BaseballGame.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball game 1세트를 수행하기위한 클래스
*/
package baseball.core;

import baseball.model.BaseballNumber;
import baseball.model.InningResult;
import baseball.view.UserInput;

public class BaseballGame {

	private final BaseballNumberService baseballNumberService;

	private final BaseballInningService baseballInningService;

	/**
	 * BaseballGame 클래스의 새 인스턴스를 초기화 합니다.
	 */
	public BaseballGame() {
		super();
		this.baseballNumberService = new BaseballNumberServiceImpl();
		BaseballNumber randomBaseballNumber = this.baseballNumberService.getRandomBaseballNumber();
		this.baseballInningService = new BaseballInningServiceImpl(randomBaseballNumber);
	}

	public void startGame() {
		// TODO baseball game start

		// 게임진행 시작, 3스트라이크가 나올때까지
		UserInput userInput = UserInput.getInstance();

		boolean isEnd = false;
		while (!isEnd) {

			System.out.print("숫자를 입력해주세요 : ");
			String inputValue = userInput.input();

			InningResult judgeInning = this.baseballInningService.judgeInning(inputValue);
			System.out.println(judgeInning.toString());
			isEnd = this.baseballInningService.isEndGame(judgeInning);
		}
		
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
}

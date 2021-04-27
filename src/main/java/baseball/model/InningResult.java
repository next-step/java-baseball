/**
* FileName : InningResult.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 입력에 대해 inning result 를 저장하는 모델
*/
package baseball.model;

import java.util.List;

public class InningResult {

	private int strike;

	private int ball;

	public InningResult() {
		this.strike = 0;
		this.ball = 0;
	}

	public int getBall() {
		return this.ball;
	}

	public int getStrike() {
		return this.strike;
	}

	/**
	 * 3스트라이크인지 확인하여 게임종료여부 반환
	 * 
	 * @return 게임종료여부
	 */
	public boolean isEndGame() {
		return this.strike == 3;
	}

	public void judgeInningResult(BaseballNumber randomBaseballNumber, UserBaseballNumber userBaseballNumber) {
		List<Integer> targetNumbers = randomBaseballNumber.getNumbers();
		for (int i = 0; i < targetNumbers.size(); i++) {
			List<Integer> userNumbers = userBaseballNumber.getNumbers();
			int userNumber = userNumbers.get(i);

			this.judgeNumber(randomBaseballNumber, i, userNumber);
		}
	}

	private void judgeNumber(BaseballNumber randomBaseballNumber, int index, int userNumber) {
		List<Integer> targetNumbers = randomBaseballNumber.getNumbers();
		if (targetNumbers.get(index) == userNumber) {
			this.plusStrikeCount();
		} else if (targetNumbers.contains(userNumber)) {
			this.plusBallCount();
		}
	}

	private void plusBallCount() {
		this.ball++;
	}

	private void plusStrikeCount() {
		this.strike++;
	}

	@Override
	public String toString() {
		return "InningResult [strike=" + strike + ", ball=" + ball + "]";
	}

}

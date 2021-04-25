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

	/**
	 * InningResult 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param strike strike 갯수
	 * @param ball   ball 갯수
	 */
	public InningResult(int strike, int ball) {
		super();
		this.strike = strike;
		this.ball = ball;
	}

	private void plusStrikeCount() {
		this.strike++;
	}

	private void plusBallCount() {
		this.ball++;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public void judgeInningResult(BaseballNumber randomBaseballNumber, BaseballNumber userBaseballNumber) {
		List<Integer> targetNumbers = randomBaseballNumber.getNumbers();
		for (int i = 0; i < targetNumbers.size(); i++) {
			List<Integer> userNumbers = userBaseballNumber.getNumbers();
			int userNumber = userNumbers.get(i);

			this.judgeNumber(targetNumbers, i, userNumber);
		}
	}

	private void judgeNumber(List<Integer> targetNumbers, int i, int userNumber) {
		if (targetNumbers.get(i) == userNumber) {
			this.plusStrikeCount();
		} else if (targetNumbers.contains(userNumber)) {
			this.plusBallCount();
		}
	}

	/**
	 * 3스트라이크인지 확인하여 게임종료여부 반환
	 * 
	 * @return 게임종료여부
	 */
	public boolean isEndGame() {
		if (this.strike == 3) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InningResult [strike=" + strike + ", ball=" + ball + "]";
	}
}

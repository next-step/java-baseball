/**
* FileName : InningResult.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 입력에 대해 inning result 를 저장하는 모델
*/
package baseball.model;

import java.util.List;
import java.util.StringJoiner;

public class InningResult {

	private int strike;

	private int ball;

	public InningResult() {
		this.strike = 0;
		this.ball = 0;
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(" ");

		if (this.strike == 0 && this.ball == 0) {
			return joiner.add("nothing").toString();
		}

		if (this.strike > 0) {
			joiner.add(String.valueOf(this.strike)).add("스트라이크");
		}

		if (this.ball > 0) {
			joiner.add(String.valueOf(this.ball)).add("볼");
		}

		return joiner.toString();
	}
}

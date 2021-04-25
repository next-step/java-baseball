/**
* FileName : InningResult.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : 사용자 입력에 대해 inning result 를 저장하는 모델
*/
package baseball.model;

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

	/**
	 * strike count를 하나 증가시킵니다.
	 */
	public void plusStrikeCount() {
		this.strike++;
	}

	/**
	 * ball count를 하나 증가시킵니다.
	 */
	public void plusBallCount() {
		this.ball++;
	}

	/**
	 * strike를 반환합니다.
	 * 
	 * @return strike
	 */
	public int getStrike() {
		return this.strike;
	}

	/**
	 * ball를 반환합니다.
	 * 
	 * @return ball
	 */
	public int getBall() {
		return this.ball;
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

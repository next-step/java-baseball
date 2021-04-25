/**
* FileName : BaseballInningServiceImpl.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball 이닝 진행 서비스 구현
*/
package baseball.core;

import java.util.List;

import baseball.model.BaseballNumber;
import baseball.model.InningResult;
import baseball.model.RandomBaseballNumber;
import baseball.model.UserBaseballNumber;

public class BaseballInningServiceImpl implements BaseballInningService {

	private final BaseballNumber targetBaseballNumber;

	/**
	 * BaseballInningServiceImpl 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @param targetBaseballNumber 컴퓨터 생성 baseballNumber
	 */
	public BaseballInningServiceImpl(BaseballNumber targetBaseballNumber) {
		this.targetBaseballNumber = targetBaseballNumber;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see baseball.core.BaseballInningService#judgeInning(java.lang.String)
	 */
	@Override
	public InningResult judgeInning(String input) {

		UserBaseballNumber userBaseballNumber = new UserBaseballNumber(input);

		InningResult inningResult = new InningResult(0, 0);
		for (int i = 0; i < this.targetBaseballNumber.getNumbers().size(); i++) {
			int userNumber = userBaseballNumber.getNumbers().get(i);
			this.judgeNumber(inningResult, this.targetBaseballNumber.getNumbers(), i, userNumber);
		}

		return inningResult;
	}

	private void judgeNumber(InningResult inningResult, List<Integer> targetNumberList, int index, int userNumber) {
		if (targetNumberList.get(index) == userNumber) {
			inningResult.plusStrikeCount();
		} else if (targetNumberList.contains(userNumber)) {
			inningResult.plusBallCount();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see baseball.core.BaseballInningService#isEndGame(baseball.model.InningResult)
	 */
	@Override
	public boolean isEndGame(InningResult inningResult) {

		int strike = inningResult.getStrike();

		if (strike == 3) {
			return true;
		}

		return false;
	}

}

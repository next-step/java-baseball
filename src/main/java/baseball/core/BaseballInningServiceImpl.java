/**
* FileName : BaseballInningServiceImpl.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball 이닝 진행 서비스 구현
*/
package baseball.core;

import java.util.ArrayList;
import java.util.List;

import baseball.model.BaseballNumber;
import baseball.model.InningResult;

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

		// TODO input validation
		BaseballNumber userBaseballNumber = this.getUserInputBaseballNumber(input);

		List<Integer> userNumberList = this.changeBaseballNumber(userBaseballNumber);
		List<Integer> targetNumberList = this.changeBaseballNumber(targetBaseballNumber);

		InningResult inningResult = new InningResult(0, 0);
		for (int i = 0; i < userNumberList.size(); i++) {
			int userNumber = userNumberList.get(i);
			this.judgeNumber(inningResult, targetNumberList, i, userNumber);
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

	private BaseballNumber getUserInputBaseballNumber(String input) {
		int inputNumber = Integer.parseInt(input);

		int first = inputNumber / 100;
		int second = inputNumber % 100 / 10;
		int third = inputNumber % 10;

		return new BaseballNumber(first, second, third);
	}

	private List<Integer> changeBaseballNumber(BaseballNumber baseballNumber) {

		ArrayList<Integer> numberList = new ArrayList<>();
		numberList.add(baseballNumber.getFirstNumber());
		numberList.add(baseballNumber.getSecondNumber());
		numberList.add(baseballNumber.getThirdNumber());

		return numberList;
	}

}

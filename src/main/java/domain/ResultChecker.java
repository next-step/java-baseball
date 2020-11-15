package domain;

import constants.Result;

public class ResultChecker {
	public static final int SUCCESS_COUNT = 3;
	private int ballCount = 0;
	private int strikeCount = 0;

	public Result checkResult(BaseballNumber userNumber, BaseballNumber randomNumber) {

		checkUnitsResult(userNumber, randomNumber);
		checkTensResult(userNumber, randomNumber);
		checkHundredsResult(userNumber, randomNumber);

		Result result = ResultFactory.getResult(strikeCount, ballCount);
		initCount();
		return result;
	}

	private void checkUnitsResult(BaseballNumber userNumber, BaseballNumber randomNumber) {
		if (randomNumber.isContain(userNumber.getUnits()) && randomNumber.getUnits() == userNumber.getUnits()) {
			strikeCount++;
			return;
		}
		if (randomNumber.isContain(userNumber.getUnits()))
			ballCount++;
	}

	private void checkTensResult(BaseballNumber userNumber, BaseballNumber randomNumber) {
		if (randomNumber.isContain(userNumber.getTens()) && randomNumber.getTens() == userNumber.getTens()) {
			strikeCount++;
			return;
		}
		if (randomNumber.isContain(userNumber.getTens()))
			ballCount++;
	}

	private void checkHundredsResult(BaseballNumber userNumber, BaseballNumber randomNumber) {
		if (randomNumber.isContain(userNumber.getHundreds())
			&& randomNumber.getHundreds() == userNumber.getHundreds()) {
			strikeCount++;
			return;
		}
		if (randomNumber.isContain(userNumber.getHundreds()))
			ballCount++;
	}

	private void initCount() {
		strikeCount = 0;
		ballCount = 0;
	}

}

package NumberBaseBallGame.Domain;

import NumberBaseBallGame.BaseBallConst;

public class Ball {
	public static final int BALL_NUMBER_MIN = BaseBallConst.INPUT_RANGE_MIN;
	public static final int BALL_NUMBER_MAX = BaseBallConst.INPUT_RANGE_MAX;
	private int valueNumber;

	public int getValueNumber() {
		return valueNumber;
	}

	public void setValueNumber(int valueNumber) {
		this.valueNumber = valueNumber;
	}
}

package NumberBaseBallGame.domain;

public class Ball {
	public static final int BALL_NUMBER_MIN = BaseBallConst.INPUT_RANGE_MIN;
	public static final int BALL_NUMBER_MAX = BaseBallConst.INPUT_RANGE_MAX;
	private int valueNumber;

	public Ball(int valueNumber) {
		if (valueNumber<BALL_NUMBER_MIN){
			throw new IllegalArgumentException("입력값은 1이상이여야 합니다.");
		}
		if (valueNumber>BALL_NUMBER_MAX){
			throw new IllegalArgumentException("입력값은 9이하이여야 합니다.");
		}
		this.valueNumber = valueNumber;
	}

	public int getValueNumber() {
		return valueNumber;
	}
}

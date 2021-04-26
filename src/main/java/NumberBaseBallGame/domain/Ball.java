package NumberBaseBallGame.domain;

import java.util.Objects;

public class Ball {
	public static final int BALL_NUMBER_MIN = BaseBallConst.INPUT_RANGE_MIN;
	public static final int BALL_NUMBER_MAX = BaseBallConst.INPUT_RANGE_MAX;
	private final int valueNumber;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ball ball = (Ball) o;
		return valueNumber == ball.valueNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valueNumber);
	}
}

package baseball.domain;

import java.util.Objects;

public class BallNumber {

	private final int num;

	public BallNumber(int num){
		this.num = num;
	}

	public int getNum(){
		return num;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BallNumber))
			return false;
		BallNumber that = (BallNumber)o;
		return num == that.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
}

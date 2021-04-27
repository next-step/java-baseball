package baseballnumber;

import java.util.HashSet;

import gamemaster.BaseballPoint;

public class BaseballNumber {
	private static final int MAX_LENGTH = 3;

	private final char[] numberDigits;

	public BaseballNumber(int number) {
		this.numberDigits = Integer.toString(number).toCharArray();
	}

	public boolean isValid() {
		if (this.numberDigits.length != MAX_LENGTH) {
			return false;
		}

		HashSet<Character> set = makeCharterSet();
		return set.size() == MAX_LENGTH;
	}

	private HashSet<Character> makeCharterSet() {
		HashSet<Character> set = new HashSet<>();
		for (Character numberDigit : this.numberDigits) {
			set.add(numberDigit);
		}
		return set;
	}

	public BaseballNumberBoard compare(BaseballNumber baseballNumber) {
		BaseballNumberBoard result = new BaseballNumberBoard(0, 0);
		for (int i = 0; i < this.numberDigits.length; i++) {
			result.accumulate(baseballNumber.compare(this.numberDigits[i], i));
		}
		return result;
	}

	private BaseballNumberBoard compare(Character input, int inputPosition) {
		for (int i = 0; i < this.numberDigits.length; i++) {
			BaseballPoint baseballPoint = calculatePoint(i, input, inputPosition);
			if (baseballPoint.isStrike() || baseballPoint.isBall()) {
				return new BaseballNumberBoard(baseballPoint);
			}
		}

		return new BaseballNumberBoard(0, 0);
	}

	public BaseballPoint calculatePoint(int currentPosition, Character input, int inputPosition) {
		if (!input.equals(this.numberDigits[currentPosition])) {
			return BaseballPoint.NONE;
		}

		if (currentPosition == inputPosition) {
			return BaseballPoint.STRIKE;
		}

		return BaseballPoint.BALL;
	}
}

package baseball.core;

public class Round {

	protected int numberLength(int number) {
		return (int)(Math.log10(number) + 1);
	}

	protected int getPlaceValue(int number, int index) {
		int length = numberLength(number);

		if (index >= length) {
			throw new IllegalArgumentException("index값이 number값에 자릿수 길이보다 같거나 깁니다.");
		}

		int t = (int)Math.pow(10, (length - 1) - index);
		return number % (t * 10) / t;
	}

}

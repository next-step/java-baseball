package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Number {
	public static final int DIGIT = 3;
	private static final int MIN_SINGLE_DIGIT = 1;
	private static final int MAX_SINGLE_DIGIT = 9;

	private int number;

	public Number(int number) {
		this.number = number;
	}

	private static int composeNumber(int... number) {
		StringBuilder numberString = new StringBuilder();
		for (int i = 0; i < DIGIT; i++) {
			numberString.append(Integer.toString(number[i]));
		}
		return Integer.parseInt(numberString.toString());
	}

	public static Number getRandomNumberWithoutDuplicate() {
		List<Integer> rangeList = getNumberRangeList();
		int[] randomNumberArray = new int[DIGIT];
		for (int i = 0; i < DIGIT; i++) {
			randomNumberArray[i] = getRandomNumberInRangeList(rangeList);
		}
		return new Number(composeNumber(randomNumberArray));
	}

	private static int getRandomNumberInRangeList(List<Integer> rangeList) {
		Random random = new Random();
		int randomIndex = random.nextInt(rangeList.size() - 1);
		int selectedNumber = rangeList.get(randomIndex);
		rangeList.remove(randomIndex);
		return selectedNumber;
	}

	private static List<Integer> getNumberRangeList() {
		List<Integer> numberRangeList = new ArrayList<>();
		for (int i = MIN_SINGLE_DIGIT; i <= MAX_SINGLE_DIGIT; i++) {
			numberRangeList.add(i);
		}
		return numberRangeList;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		Number number1 = (Number)object;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}

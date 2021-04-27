package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
	public static final int DIGIT = 3;
	private static final int MIN_SINGLE_DIGIT = 1;
	private static final int MAX_SINGLE_DIGIT = 9;
	private static final String OUT_OF_RANGE =
		MIN_SINGLE_DIGIT + "부터 " + MAX_SINGLE_DIGIT + "까지 서로 다른 " + DIGIT + "자릿수 여야 합니다.";
	private static final String DUPLICATED_NUMBER = "중복된 숫자를 입력하였습니다.";
	private static final String DUPLICATED_NUMBER_REGEX =
		"([" + MIN_SINGLE_DIGIT + "-" + MAX_SINGLE_DIGIT + "])(?=[" + MIN_SINGLE_DIGIT + "-" + MAX_SINGLE_DIGIT
			+ "]*\\1)";

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

	public static Number isValidate(int input) {
		Number number = new Number(input);
		number.isValidateDigit();
		number.isDuplicatedDigitNumber();
		return number;
	}

	private void isValidateDigit() {
		ArrayList<String> list = numberToStringList();
		if (list.size() != DIGIT) {
			throw new IllegalArgumentException(OUT_OF_RANGE);
		}
		for (String s : list) {
			int parse = Integer.parseInt(s);
			isInRange(parse);
		}
	}

	private void isInRange(int parse) {
		if (parse < MIN_SINGLE_DIGIT
			|| parse > MAX_SINGLE_DIGIT) {
			throw new IllegalArgumentException(OUT_OF_RANGE);
		}
	}

	private void isDuplicatedDigitNumber() {
		Pattern pattern = Pattern.compile(DUPLICATED_NUMBER_REGEX);
		Matcher matcher = pattern.matcher(Integer.toString(this.number));
		if (matcher.find()) {
			throw new IllegalArgumentException(DUPLICATED_NUMBER);
		}
	}

	public ArrayList<String> numberToStringList() {
		return new ArrayList<>(Arrays.asList(Integer.toString(this.number).split("")));
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

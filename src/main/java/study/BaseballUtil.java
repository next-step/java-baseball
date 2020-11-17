package study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballUtil {

	public static List<Integer> toList(int number) {
		int temp;

		int firstNumber = number / 100;
		temp = number % 100;

		int secondNumber = temp / 10;
		temp = temp % 10;

		int thridNumber = temp;

		List<Integer> numbers = Arrays.asList(firstNumber, secondNumber, thridNumber);
		BaseballUtil.validate(numbers);

		return numbers;
	}

	public static void validate(List<Integer> numbers) {
		Set<Integer> set = new HashSet<>(numbers);
		if (set.size() != 3) {
			throw new IllegalArgumentException("Duplicate number not allowed.");
		}

		for (final Integer number : numbers) {
			if (number > 9) {
				throw new IllegalArgumentException("Out of range..");
			}
		}
	}
}

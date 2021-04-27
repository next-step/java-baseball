package baseball.util.checker;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class BaseballInputCheckerImpl implements InputChecker {

	Predicate<String> isValidNumRange = input -> {
		int value = Integer.parseInt(input);
		return value > 111 && value < 999;
	};

	Predicate<String> noDuplicateNum = input -> {
		Set<Integer> nums = new HashSet<>();

		for (char ch : input.toCharArray()) {
			nums.add(Integer.parseInt(String.valueOf(ch)));
		}
		return nums.size() == 3;
	};

	@Override
	public boolean check(String input) {

		return IS_VALID_NUM_FORMAT.and(isValidNumRange).and(noDuplicateNum).test(input);
	}
}

package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballNumbersFactory {

	private static final List<Integer> cacheNumbers = new ArrayList<>();

	private static final Map<Integer, BaseballNumber> cacheBaseballNumbers = new HashMap<>();

	static {
		for (int i = 1; i < 10; i++) {
			cacheNumbers.add(i);
			cacheBaseballNumbers.put(i, new BaseballNumber(i));
		}
	}

	private BaseballNumbersFactory() { }

	public static List<BaseballNumber> create(int size) {
		Collections.shuffle(cacheNumbers);

		List<BaseballNumber> baseballNumbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			baseballNumbers.add(cacheBaseballNumbers.get(cacheNumbers.get(i)));
		}

		return baseballNumbers;
	}

	public static List<BaseballNumber> create(String value) {
		List<BaseballNumber> baseballNumbers = new ArrayList<>();
		for (int i = 0; i < value.length(); i++) {
			int number = Character.getNumericValue(value.charAt(i));
			baseballNumbers.add(cacheBaseballNumbers.get(number));
		}

		return baseballNumbers;
	}

}

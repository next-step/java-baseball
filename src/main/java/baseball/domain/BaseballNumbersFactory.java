package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumbersFactory {

	private static List<BaseballNumber> cacheBaseballNumbers = new ArrayList<>();

	static {
		for (int i = 1; i < 10; i++) {
			cacheBaseballNumbers.add(new BaseballNumber(i));
		}
	}

	private BaseballNumbersFactory() { }

	public static List<BaseballNumber> create(int size) {
		Collections.shuffle(cacheBaseballNumbers);

		List<BaseballNumber> baseballNumbers  = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			baseballNumbers.add(cacheBaseballNumbers.get(i));
		}

		return baseballNumbers;
	}

}

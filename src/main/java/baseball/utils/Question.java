package baseball.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author forrest-k
 */
public class Question {

	public Map<String, Integer> getValues() {
		return randomNumber(3,1,9);
	}

	private Map<String, Integer> randomNumber(int digit, int startNumber, int endNumber) {
		Map<String, Integer> questionMap = new HashMap<>();

		do {
			int n = new Random().nextInt(9) + 1;
			String t = n + "";

			if(questionMap.get("t") != null) {
				continue;
			}

			questionMap.put(t, questionMap.size() + 1);
		} while (questionMap.size() < digit);

		return questionMap;
	}
}

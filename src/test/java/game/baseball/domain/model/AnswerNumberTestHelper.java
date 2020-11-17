package game.baseball.domain.model;

import java.util.List;
import java.util.Map;

public class AnswerNumberTestHelper {

	public static AnswerNumber generateAnswerNumber(List<Integer> numbers, Map<Integer, Integer> numberIndexMap) {
		return new AnswerNumber(numbers, numberIndexMap);
	}
}

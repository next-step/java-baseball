package baseball.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerServiceImpl implements AnswerService {

	@Override
	public List<Integer> buildAnswer() {
		Set<Integer> set = new HashSet<>();
		while (set.size() < 3) {
			int random = (int)(Math.random() * 8) + 1;
			set.add(random);
		}
		List<Integer> answer = new ArrayList(set);
		Collections.shuffle(answer);
		return answer;
	}
}

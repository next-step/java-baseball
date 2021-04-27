package baseball.answer;

import static baseball.BaseBallApplication.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerServiceImpl implements AnswerService {

	@Override
	public List<Integer> buildAnswer() {
		Set<Integer> set = new HashSet<>();
		while (set.size() < BALL_COUNT) {
			int random = (int)(Math.random() * 9) + 1;
			set.add(random);
		}
		List<Integer> answer = new ArrayList(set);
		Collections.shuffle(answer);
		return answer;
	}
}

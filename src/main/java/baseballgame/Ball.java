package baseballgame;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Ball {
	private Set<Integer> answerSet;

	public void makeRandomlyThreeDigitAnswer() {
		answerSet = new LinkedHashSet<>();
		while (answerSet.size() < 3) {
			answerSet.add((int)(Math.random() * 9 + 1));
		}
	}

	public List<Integer> getAnswerArray() {
		List<Integer> answerList = new ArrayList<>(answerSet);
		return answerList;
	}
}

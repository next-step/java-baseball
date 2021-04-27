package baseball.service.game;

import java.util.List;

import baseball.utils.IntegerUtil;

public class BaseballGameService {
	public int getStrikeCount(List<Integer> answer, List<Integer> userAnswer) {
		int count = 0;
		for (int i = 0; i < answer.size(); ++i) {
			count +=  IntegerUtil.compareValues(answer.get(i), userAnswer.get(i));
		}
		return count;
	}
}

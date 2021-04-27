package baseball.service.game;

import java.util.List;

import baseball.model.BaseballResult;
import baseball.utils.IntegerUtil;

public class BaseballGameService {

	public BaseballResult getResult(List<Integer> answer, List<Integer> userAnswer) {
		int strikeCount = getStrikeCount(answer, userAnswer);
		int ballCount = getBallCount(answer, userAnswer);
		return new BaseballResult(strikeCount, ballCount);
	}

	public int getStrikeCount(List<Integer> answer, List<Integer> userAnswer) {
		int count = 0;
		for (int i = 0; i < answer.size(); ++i) {
			count +=  IntegerUtil.compareValues(answer.get(i), userAnswer.get(i));
		}
		return count;
	}

	public int getBallCount(List<Integer> answer, List<Integer> userAnswer) {
		int count = 0;
		for (int i = 0; i < answer.size(); ++i) {
			count += IntegerUtil.containsValueNotOnSameIndex(userAnswer, answer.get(i), i) ? 1 : 0;
		}
		return count;
	}
}

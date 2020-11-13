package application;

import java.util.HashMap;
import java.util.Map;

import domain.BaseballNumber;
import domain.BaseballNumbers;
import domain.Score;
import utils.BaseballNumberFactory;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임 비즈니스로직
 **/
public class BaseballService {
	private static BaseballNumberFactory baseballNumberFactory = new BaseballNumberFactory();
	private static Score score;

	public BaseballNumbers generateAnswer() {
		return baseballNumberFactory.generateNumbers();
	}

	public Score checkBaseballNumber(String playerBaseballNumber, BaseballNumbers answerNumbers) {
		score = new Score();
		BaseballNumbers playerBaseballNumbers = new BaseballNumbers(playerBaseballNumber);
		Map<Integer, Integer> answerMap = new HashMap<>();
		for (BaseballNumber answerNumber : answerNumbers.getValues()) {
			answerMap.put(answerNumber.getValue(), answerNumbers.getBaseballPosition(answerNumber));
			calculate(answerNumber, answerMap, playerBaseballNumbers);
		}
		return score;
	}

	public void calculate(BaseballNumber answerNumber, Map<Integer, Integer> answerMap,
		BaseballNumbers playerBaseballNumbers) {
		if (playerBaseballNumbers.contains(answerNumber) && (playerBaseballNumbers.getBaseballPosition(answerNumber)
			== answerMap.get(answerNumber.getValue()))) {
			score.addStrike();
		}
		if (playerBaseballNumbers.contains(answerNumber) && (playerBaseballNumbers.getBaseballPosition(answerNumber)
			!= answerMap.get(answerNumber.getValue()))) {
			score.addBall();
		}
	}

}

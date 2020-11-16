package domain;

import java.util.ArrayList;
import java.util.List;

import domain.baseballRule.Ball;
import domain.baseballRule.BaseballNumbers;
import domain.baseballRule.BaseballResult;
import domain.baseballRule.Strike;

public class Referee {

	public BaseballResult checkBaseballResult(BaseballNumbers players, BaseballNumbers opponents) {
		BaseballResult baseballResult = new BaseballResult();
		for (int idx = 0; idx < players.size(); idx++) {
			baseballResult.add(countStrikeAndBall(players.getByIndex(idx), idx, opponents));
		}
		return baseballResult;
	}

	private BaseballResult countStrikeAndBall(Integer number, int idx, BaseballNumbers opponents) {
		BaseballResult baseballResult = new BaseballResult();
		Strike strike = countStrike(number, idx, opponents);

		if (strike.isStrike()) {
			baseballResult.addStrike(strike);
			return baseballResult;
		}

		Ball ball = countBall(number, idx, opponents);
		baseballResult.addBall(ball);

		return baseballResult;
	}

	private Strike countStrike(Integer number, int idx, BaseballNumbers opponents) {
		if (opponents.getByIndex(idx).equals(number))
			return Strike.newOneStrike();
		return Strike.newZeroStrike();
	}

	private Ball countBall(Integer number, int idx, BaseballNumbers opponents) {
		List<Integer> opponentsCopy = new ArrayList<>(opponents.baseballNumbers());
		opponentsCopy.remove(idx);
		if (opponentsCopy.contains(number))
			return Ball.newOneBall();
		return Ball.newZeroBall();
	}
}

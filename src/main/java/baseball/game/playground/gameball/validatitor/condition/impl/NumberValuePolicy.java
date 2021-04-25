package baseball.game.playground.gameball.validatitor.condition.impl;

import baseball.game.playground.gameball.validatitor.condition.ConditionPolicy;

// 유효성 검증 - 번호인지
public class NumberValuePolicy implements ConditionPolicy {

	@Override
	public boolean isSatisfied(String inputString) {

		return inputString.matches("^[1-9]+$");
	}
}

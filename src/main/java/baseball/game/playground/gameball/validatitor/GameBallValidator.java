package baseball.game.playground.gameball.validatitor;

import baseball.game.playground.gameball.validatitor.condition.ConditionPolicy;
import baseball.game.playground.gameball.validatitor.condition.impl.DigitNumberPolicy;
import baseball.game.playground.gameball.validatitor.condition.impl.NumberValuePolicy;
import baseball.game.playground.gameball.validatitor.condition.impl.OverlapNumberPolicy;

public class GameBallValidator {

	private static final ConditionPolicy[] conditionPolicies = new ConditionPolicy[] {
		new DigitNumberPolicy(),
		new NumberValuePolicy(),
		new OverlapNumberPolicy(),
	};

	public static boolean isSatisfied(String inputString) {

		for (ConditionPolicy policy : conditionPolicies) {
			if (!policy.isSatisfied(inputString)) {
				return false;
			}
		}
		return true;
	}

	public static void checkValidation(String string) {

		boolean validation = isSatisfied(string);
		if (!validation) {
			throw new IllegalArgumentException();
		}

	}
}

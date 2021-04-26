package baseball.game.gameball.validatitor;

import baseball.game.gameball.validatitor.condition.ConditionPolicy;
import baseball.game.gameball.validatitor.condition.impl.DigitNumberPolicy;
import baseball.game.gameball.validatitor.condition.impl.NumberValuePolicy;
import baseball.game.gameball.validatitor.condition.impl.OverlapNumberPolicy;

public class InputStringValidator {

	private static final ConditionPolicy[] conditionPolicies = new ConditionPolicy[]{
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

	public static void check(String string) {

		boolean validation = isSatisfied(string);
		if (!validation) {
			throw new IllegalArgumentException();
		}

	}
}

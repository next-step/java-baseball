package rule;

import number.BaseballNumbers;

public class Rule {

	private static Rule rule = new Rule();

	private Rule() {

	}

	public static Rule getInstance() {
		return rule;
	}

	public int countStrike(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
		int result = 0;

		for (int i = 0; i < computerBaseballNumbers.size(); i++) {
			result += isEquals(computerBaseballNumbers.get(i), userBaseballNumbers.get(i));
		}

		return result;
	}

	private int isEquals(Integer computerNumber, Integer userNumber) {
		return computerNumber.equals(userNumber) ? 1 : 0;
	}

	public int countBall(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
		int result = 0;

		for (int i = 0; i < computerBaseballNumbers.size(); i++) {
			result += isContains(computerBaseballNumbers, userBaseballNumbers.get(i));
		}

		result -= countStrike(computerBaseballNumbers, userBaseballNumbers);

		return result;

	}

	private int isContains(BaseballNumbers computerBaseballNumbers, Integer userNumber) {
		return computerBaseballNumbers.contains(userNumber) ? 1 : 0;
	}

	public boolean isThreeStrike(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
		return countStrike(computerBaseballNumbers, userBaseballNumbers) == computerBaseballNumbers.size();
	}

	public boolean isNothing(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
		return countStrike(computerBaseballNumbers, userBaseballNumbers)
				+ countBall(computerBaseballNumbers, userBaseballNumbers) == 0;
	}
}

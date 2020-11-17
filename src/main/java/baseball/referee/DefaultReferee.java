package baseball.referee;

import java.util.List;
import java.util.function.BiFunction;

import baseball.opponent.Opponent;
import baseball.player.Player;
import baseball.report.Report;

public class DefaultReferee implements Referee {
	private final BiFunction compareStrikeFunction = (numberIndex, hiddenNumberIndex) -> numberIndex
		== hiddenNumberIndex;
	private final BiFunction compareBallFunction = (numberIndex, hiddenNumberIndex) -> numberIndex != hiddenNumberIndex;
	private Opponent opponent;

	public DefaultReferee(Opponent opponent) {
		this.opponent = opponent;
	}

	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}

	private Report decide(List<Integer> requestNumbers) {
		int strike = countFromRequestNumber(requestNumbers, compareStrikeFunction);
		int ball = countFromRequestNumber(requestNumbers, compareBallFunction);

		return new Report(strike, ball);
	}

	private Integer countFromRequestNumber(List<Integer> requestNumbers, BiFunction compareFunction) {
		int count = 0;
		for (int i = 0; i < requestNumbers.size(); i++) {
			count += countFromHiddenNumber(i, requestNumbers.get(i), compareFunction);
		}

		return count;
	}

	private int countFromHiddenNumber(Integer requestIndex, Integer requestNumber,
		BiFunction<Integer, Integer, Boolean> compareFunction) {
		List<Integer> hiddenNumber = opponent.getHiddenNumbers();
		int count = 0;

		for (int i = 0; i < hiddenNumber.size(); i++) {
			count += compare(requestNumber, hiddenNumber.get(i), compareFunction.apply(requestIndex, i));
		}

		return count;
	}

	private int compare(Integer requestNumber, Integer hiddenNumber, Boolean isEqualsIndex) {
		if (requestNumber.equals(hiddenNumber) && isEqualsIndex)
			return 1;

		return 0;
	}

	public Report decide(Player player) {
		return this.decide(player.getRequestNumbers());
	}

	public void resetOpponent() {
		opponent.reset();
	}
}

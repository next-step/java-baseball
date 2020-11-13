package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class Guesser {

	private Guesser() {

	}

	static GuessResult guess(List<Integer> computerNumbers, List<Integer> myNumbers) {
		int strikeCount = getStrikeCount(computerNumbers, myNumbers);
		int ballCount = getBallCount(computerNumbers, myNumbers);
		return new GuessResult(strikeCount, ballCount);
	}

	private static int getStrikeCount(List<Integer> computerNumbers, List<Integer> myNumbers) {
		int strikeCount = 0;
		for (int i = 0; i < myNumbers.size(); i++) {
			int myNumber = myNumbers.get(i);
			int computerNumber = computerNumbers.get(i);
			strikeCount = computerNumber == myNumber
				? strikeCount + 1
				: strikeCount;
		}
		return strikeCount;
	}

	private static int getBallCount(List<Integer> computerNumbers, List<Integer> myNumbers) {
		int ballCount = 0;
		Set<Integer> computerNumbersSet = new HashSet<>(computerNumbers);
		for (int i = 0; i < myNumbers.size(); i++) {
			int myNumber = myNumbers.get(i);
			ballCount = computerNumbersSet.contains(myNumber) && computerNumbers.get(i) != myNumber
				? ballCount + 1
				: ballCount;
		}
		return ballCount;
	}
}

package baseball.util;

import java.util.Set;

public class CompareComputerPlayerNumber {

	public static Integer[] compareStrikeAndBall(Set<Integer> computerNumbers, Set<Integer> playerNumbers) {
		Integer[] score = new Integer[] {0, 0};
		Integer position = 0;

		for (Integer computerNumber : computerNumbers) {
			score = getScore(position, score, computerNumber, playerNumbers);
			position++;
		}

		return score;
	}

	public static Integer[] getScore(Integer position, Integer[] score, Integer computerNumber,
		Set<Integer> playerNumbers) {

		if (playerNumbers.contains(computerNumber)) {
			score = calculateScoreBasedStrikeOrBall(position, score, computerNumber, playerNumbers);
		}

		return score;
	}

	public static Integer[] calculateScoreBasedStrikeOrBall(Integer position, Integer[] score, Integer computerNumber,
		Set<Integer> playerNumbers) {
		Integer[] playerNumberArray = playerNumbers.toArray(new Integer[] {});

		if (playerNumberArray[position] == computerNumber) {
			score[0]++;
		}
		if (playerNumberArray[position] != computerNumber) {
			score[1]++;
		}

		return score;
	}
}

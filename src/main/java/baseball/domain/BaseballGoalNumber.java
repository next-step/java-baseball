package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import baseball.BaseballGame;
import baseball.util.Validation;

public class BaseballGoalNumber {

	private static final Random random = new Random();

	public Set<Integer> goalNumberArray;

	public BaseballGoalNumber() {
		this.goalNumberArray = getBaseballGoal();
	}

	private Set<Integer> getBaseballGoal() {

		Set<Integer> baseballGoal = new HashSet<>();

		while (baseballGoal.size() < BaseballGame.BASEBALL_GAME_COUNT) {
			baseballGoal.add(random.nextInt(BaseballGame.BASEBALL_GAME_RANGE) + 1);
		}

		return baseballGoal;
	}
}


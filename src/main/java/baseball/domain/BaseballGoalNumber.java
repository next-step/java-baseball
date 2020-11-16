package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseballGoalNumber {

	public static final int BASEBALL_GAME_COUNT = 3;
	public static final int BASEBALL_GAME_RANGE = 8;

	private static final Random random = new Random();
	private Set<Integer> goalSet;

	public List<Integer> baseballGoalNumber;

	public BaseballGoalNumber() {

		init();
		getBaseballGoal();
	}

	private void init() {
		this.goalSet = new HashSet<>();
		this.baseballGoalNumber = new ArrayList<>();
	}

	private void getBaseballGoal() {

		while (this.goalSet.size() < BASEBALL_GAME_COUNT) {

			Integer randomNumber = random.nextInt(BASEBALL_GAME_RANGE) + 1;

			validateBaseball(randomNumber);
		}

	}

	private void validateBaseball(Integer randomNumber) {

		if (this.goalSet.add(randomNumber)) {

			this.baseballGoalNumber.add(randomNumber);
		}
	}
}


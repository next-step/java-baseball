package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.dao.BaseballConstant;

public class BaseballGameService extends BaseballConstant {

	public static List<Integer> baseGoalNumber;

	public static boolean isThreeStrikeGame(List<Integer> baseballGoalNumber, List<Integer> userInputBaseballNumber) {

		BaseballConstant.initBaseball();
		baseGoalNumber = new ArrayList<>(baseballGoalNumber);

		calculateBaseballList(baseballGoalNumber, userInputBaseballNumber);
		printBaseballScore();

		return isAllStrike();
	}

	private static void calculateBaseballList(List<Integer> baseballGoal, List<Integer> userInputBaseball) {

		for (int i = 0; i < baseballGoal.size(); i++) {

			calculateStrike(baseballGoal, userInputBaseball, i);
		}

		if (isAllStrike()) {
			calculateBall(userInputBaseball);
		}
	}

	private static void calculateStrike(List<Integer> baseballGoal, List<Integer> inputNumber, int index) {

		if (baseballGoal.get(index).equals(inputNumber.get(index))) {

			strike++;
			baseGoalNumber.remove(baseballGoal.get(index));
		}
	}

	private static void calculateBall(List<Integer> userInputBaseball) {

		for (Integer goalNumber : baseGoalNumber) {
			ball += userInputBaseball.contains(goalNumber) ? 1 : 0;
		}
	}

	private static boolean isAllStrike() {

		return !BaseballConstant.strike.equals(BASEBALL_GAME_COUNT);
	}

	public static boolean isStartGame(Integer gameStartState) {

		return gameStartState.equals(BASEBALL_GAME_RESTART);
	}

}

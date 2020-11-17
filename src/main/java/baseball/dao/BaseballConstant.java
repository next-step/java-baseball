package baseball.dao;

import java.util.List;
import java.util.Set;

import baseball.util.UserOutput;

public class BaseballConstant {

	public static final Integer BASEBALL_GAME_COUNT = 3;
	public static final Integer BASEBALL_GAME_RANGE = 8;
	public static final Integer BASEBALL_GAME_RESTART = 1;
	public static final Integer BASEBALL_GAME_END = 2;

	public List<Integer> baseballGoalNumber;
	public Set<Integer> duplicateCheckSet;

	public static Integer strike = 0;
	public static Integer ball = 0;

	public static void printBaseballScore() {

		if (ball != 0) {
			UserOutput.printBall(ball);
		}

		if (strike != 0) {
			UserOutput.printStrike(strike);
		}

		if (ball == 0 && strike == 0) {
			UserOutput.printNothing();
		}

		UserOutput.printNextLine();
	}

	public static void initBaseball() {

		strike = 0;
		ball = 0;
	}
}

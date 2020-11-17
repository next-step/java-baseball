package baseball.dao;

import java.util.List;
import java.util.Set;

import baseball.util.UserOutput;

public class BaseballConstant {

	public static final Integer BASEBALL_GAME_COUNT = 3;
	public static final Integer BASEBALL_GAME_RANGE = 8;
	public static final Integer BASEBALL_GAME_RESTART = 1;
	public static final Integer BASEBALL_GAME_END = 2;

	// 야구게임 랜덤 상수 및 사용자 입력 수 List변수
	public List<Integer> baseballGoalNumber;

	// 중복 방지 관리 Set변수
	public Set<Integer> duplicateCheckSet;

	// 야구게임 결과 Strik, Ball 관리 변수
	public static Integer strike = 0;
	public static Integer ball = 0;

	/**
	 * 야구게임 결과 프린트 메서드
	 */
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

		if (strike.equals(BASEBALL_GAME_COUNT)) {
			UserOutput.printGameEnd();
		}
	}

	/**
	 * 야구게임 결과 초기화
	 */
	public static void initBaseball() {

		strike = 0;
		ball = 0;
	}
}

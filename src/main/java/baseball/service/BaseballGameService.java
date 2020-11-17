package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.dao.BaseballConstant;

public class BaseballGameService extends BaseballConstant {

	// baseballGoalNumber 복제 List변수
	public static List<Integer> baseGoalNumber;

	/**
	 * 야구게임 임의의 수와 유저 입력 수 비교 시작 메서드(초기화 및 데이터 생성)
	 * @param baseballGoalNumber : 야구게임 임의의 수 3자리
	 * @param userInputBaseballNumber : 유저 입력 수 3자리
	 * @return : 3Strike 여부
	 */
	public static boolean isThreeStrikeGame(List<Integer> baseballGoalNumber, List<Integer> userInputBaseballNumber) {

		BaseballConstant.initBaseball();
		baseGoalNumber = new ArrayList<>(baseballGoalNumber);

		calculateBaseballList(baseballGoalNumber, userInputBaseballNumber);
		printBaseballScore();

		return isAllStrike();
	}

	/**
	 * 야구게임 임의의 수와 유저 입력 수 판단 메서드
	 * @param baseballGoal : 야구게임 임의의 수 3자리
	 * @param userInputBaseball : 유저 입력 수 3자리
	 */
	private static void calculateBaseballList(List<Integer> baseballGoal, List<Integer> userInputBaseball) {

		for (int i = 0; i < baseballGoal.size(); i++) {

			// 스트라이크 수 체크
			calculateStrike(baseballGoal, userInputBaseball, i);
		}

		// 3 Stike가 아닐 경우
		if (isAllStrike()) {

			// 볼 수 체크
			calculateBall(userInputBaseball);
		}
	}

	/**
	 * 스트라이크 수 체크 판단 메서드
	 * @param baseballGoal : 야구게임 임의의 수
	 * @param inputNumber : 유저 입력 수
	 * @param index : 같은 자리 판단 인덱스
	 */
	private static void calculateStrike(List<Integer> baseballGoal, List<Integer> inputNumber, int index) {

		// 자리수와 값이 같다면
		if (baseballGoal.get(index).equals(inputNumber.get(index))) {

			// 복제 리스트에서 목록 제거 (빠른 볼 계산을 위해)
			baseGoalNumber.remove(baseballGoal.get(index));
			strike++;
		}
	}

	/**
	 * 볼 수 체크 판단 메서드
	 * @param userInputBaseball : 유저 입력 수 List
	 */
	private static void calculateBall(List<Integer> userInputBaseball) {

		// 스트라이크를 제외한 야구게임 임의의 수
		for (Integer goalNumber : baseGoalNumber) {

			// 유저 입력 수에 포함 되는지 판단하여 볼 갯수 체크
			ball += userInputBaseball.contains(goalNumber) ? 1 : 0;
		}
	}

	/**
	 * 3 Strkie 판단 메서드
	 * @return : 3 Strike 여부
	 */
	private static boolean isAllStrike() {

		return !BaseballConstant.strike.equals(BASEBALL_GAME_COUNT);
	}

	/**
	 * 게임 재시작 판단 여부
	 * @param gameStartState : 유저 게임 재시작 입력 수
	 * @return : 게임 재시작 여부
	 */
	public static boolean isStartGame(Integer gameStartState) {

		return gameStartState.equals(BASEBALL_GAME_RESTART);
	}

}

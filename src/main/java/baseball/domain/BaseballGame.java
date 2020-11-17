package baseball.domain;

import baseball.service.BaseballGameService;
import baseball.util.UserInput;

public class BaseballGame {

	// 유저 입력 관리 클래스
	private static final UserInput INPUT = new UserInput();

	/**
	 * 야구 게임 시작 메서드- 게임이 끝나면, 게임 재시작 여부 출력
	 */
	public static void start() {
		do {
			playBallGame(new BaseballGoalNumber());
		} while (isContinue());
	}

	/**
	 * 야구 게임 진행 관리 메서드- 유저가 입력한 수와 비교하여, 3 Strike가 나올때까지 반복한다.
	 * @param baseball: 랜덤 상수 생성
	 */
	private static void playBallGame(BaseballGoalNumber baseball) {

		do {
			INPUT.userInputBaseballNumber();
		} while (BaseballGameService.isThreeStrikeGame(baseball.baseballGoalNumber, INPUT.baseballGoalNumber));
	}

	/**
	 * 게임 재시작 여부를 입력받는 메서드
	 * @return 게임 재시작 여부(1: 재시작, 2:종료)
	 */
	private static boolean isContinue() {

		return BaseballGameService.isStartGame(INPUT.userInputContinueNumber());
	}
}

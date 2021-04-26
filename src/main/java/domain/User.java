package domain;

import util.InputView;
import util.Validation;

public class User {
	// 사용자의 정답 입력 및 메시지 출력
	public static String getUserAnswer() {
		boolean determination = false;
		String userAnswer = "";
		while (!determination) {
			userAnswer = InputView.getAnswer();
			determination = Validation.isValidAnswer(userAnswer);
		}

		return userAnswer;
	}

	// 사용자의 게임 재시작 여부 입력 및 메시지 출력
	public static String getUserRetry() {
		boolean determination = false;
		String restartOrNot = "";
		while (!determination) {
			restartOrNot = InputView.restartOrNot();
			determination = Validation.isValidToRestart(restartOrNot);
		}

		return restartOrNot;
	}
}

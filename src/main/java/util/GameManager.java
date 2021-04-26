package util;

import constant.GameRules;
import dto.GameResult;
import view.GameView;

public class GameManager {
	private final String answer;

	public GameManager() {
		this.answer = GameUtil.getRandomNumber();
	}

	public String getAnswer() {
		return this.answer;
	}

	public GameResult checkResult(String answer, String userInput) {
		int strikeCnt = GameRules.Strike.getApply().apply(answer, userInput);
		int ballCnt = GameRules.Ball.getApply().apply(answer, userInput);
		return getResult(strikeCnt, ballCnt);
	}

	private GameResult getResult(int strikeCnt, int ballCnt) {
		String currMsg = strikeCnt > 0 ? String.format("%d %s ", strikeCnt, GameRules.Strike.getMsg()) : "";
		if (strikeCnt == GameUtil.LIMIT_DIGIT) {
			return new GameResult(String.format("%s\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료", currMsg.trim(), strikeCnt), true);
		}
		currMsg = ballCnt > 0 ? currMsg + String.format("%d %s ", ballCnt, GameRules.Ball.getMsg()) : currMsg;
		if (strikeCnt > 0 || ballCnt > 0) {
			return new GameResult(String.format("%s", currMsg.trim()), false);
		}
		return new GameResult("낫싱", false);
	}

	public void gameStart() {
		String inputNumber;
		do {
			inputNumber = GameView.inputNumberView();
		} while (!GameView.resultView(checkResult(inputNumber, this.answer)));
	}

}

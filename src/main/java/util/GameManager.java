package util;

import constant.GameRules;
import dto.GameResult;
import validator.GameRulesValidator;
import view.GameView;

public class GameManager {
	private String answer;
	private GameRulesValidator gameRulesValidator;

	public GameManager() {
		this.gameRulesValidator = new GameRulesValidator();
	}

	public String getAnswer() {
		return this.answer;
	}

	private void setAnswer() {
		this.answer = GameUtil.getRandomNumber();
	}

	public void run() {
		do {
			gameStart();
		} while (GameView.endView());
	}

	private void gameStart() {
		this.setAnswer();
		gameProcessing();
	}

	private void gameProcessing() {
		String inputNumber;
		do {
			inputNumber = GameView.inputNumberView();
		} while (!GameView.resultView(checkResult(inputNumber, this.answer)));
	}

	public GameResult checkResult(String answer, String userInput) {
		int strikeCnt = GameRules.getStrikeCnt(answer, userInput);
		int ballCnt = GameRules.getBallCnt(answer, userInput);
		return getResult(strikeCnt, ballCnt);
	}

	private GameResult getResult(int strikeCnt, int ballCnt) {
		String currMsg = gameRulesValidator.checkStrike(strikeCnt, ballCnt) ? strikeMsg(strikeCnt) : "";
		if (gameRulesValidator.checkSuccess(strikeCnt, ballCnt)) {
			return new GameResult(successMsg(strikeCnt), true);
		}
		currMsg = gameRulesValidator.checkBall(strikeCnt, ballCnt) ? currMsg + ballMsg(ballCnt) : currMsg;
		if (gameRulesValidator.checkStrike(strikeCnt, ballCnt) || gameRulesValidator.checkBall(strikeCnt, ballCnt)) {
			return new GameResult(String.format("%s", currMsg.trim()), false);
		}
		return new GameResult(nothingMsg(ballCnt), false);
	}

	private String successMsg(int strikeCnt) {
		return GameRules.Success.getMsg().apply(strikeCnt);
	}

	private String strikeMsg(int strikeCnt) {
		return GameRules.Strike.getMsg().apply(strikeCnt);
	}

	private String ballMsg(int ballCnt) {
		return GameRules.Ball.getMsg().apply(ballCnt);
	}

	private String nothingMsg(int ballCnt) {
		return GameRules.Nothing.getMsg().apply(ballCnt);
	}
}

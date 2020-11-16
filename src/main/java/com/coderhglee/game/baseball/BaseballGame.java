package com.coderhglee.game.baseball;

import com.coderhglee.game.Game;
import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.number.InputNumber;
import com.coderhglee.game.number.NumberCompareResult;
import com.coderhglee.game.number.NumberGroups;
import com.coderhglee.game.number.NumberGroupsHelper;
import com.coderhglee.game.number.RandomInputNumber;


public class BaseballGame implements Game<BaseballGameStatus> {
	BaseballGameStatus gameStatus;
	NumberGroups correctAnswer;
	String baseballGameMessageForUser;

	public BaseballGame() throws GameException {
		RandomInputNumber randomInputNumber = new RandomInputNumber();
		this.correctAnswer = randomInputNumber.getInputNumber();
		this.gameStatus = BaseballGameStatus.NOTING;
	}

	public BaseballGame(InputNumber inputNumber) {
		this.correctAnswer = inputNumber.getInputNumber();
		this.gameStatus = BaseballGameStatus.NOTING;
	}

	@Override
	public void gameProcess(InputNumber inputNumber) {
		NumberGroups inputNumberGroups = inputNumber.getInputNumber();
		NumberCompareResult compareResult = NumberGroupsHelper.compareEachNumber(correctAnswer, inputNumberGroups);
		if (isScoreSameGameStatus(compareResult.getNumberAndDigitSameScore(), BaseballGameStatus.WIN)) {
			return;
		}
		if (isScoreSameGameStatus(compareResult.getAllCompareScore(), BaseballGameStatus.NOTING)) {
			return;
		}
		setGameStatusAndMessageForHint(compareResult);
	}

	@Override
	public String getGameResultMessage() {
		return this.baseballGameMessageForUser;
	}

	private boolean isScoreSameGameStatus(int gameScore, BaseballGameStatus gameStatus) {
		if (gameScore == gameStatus.getStatusScore()) {
			setGameStatusAndMessage(gameStatus);
			return true;
		}
		return false;
	}

	private void setGameStatusAndMessage(BaseballGameStatus messageForUser) {
		gameStatus = messageForUser;
		baseballGameMessageForUser = messageForUser.getMessageForUser();
	}

	private void setGameStatusAndMessageForHint(NumberCompareResult numberCompareResult) {
		gameStatus = BaseballGameStatus.HINT;
		baseballGameMessageForUser = BaseballGameStatus.HINT.getMessageForUser(numberCompareResult);
	}

	public BaseballGameStatus getGameStatus() {
		return gameStatus;
	}
}

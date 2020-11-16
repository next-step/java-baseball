package com.coderhglee.game.baseball;

import com.coderhglee.game.Game;
import com.coderhglee.game.number.GameNumberCompareResult;
import com.coderhglee.game.number.GameNumberGroups;
import com.coderhglee.game.number.GameNumberGroupsHelper;
import com.coderhglee.game.number.InputNumber;
import com.coderhglee.game.number.RandomInputNumber;
import com.coderhglee.game.exception.GameException;

public class BaseballGame implements Game<BaseballGameStatus> {
    BaseballGameStatus gameStatus;
    GameNumberGroups correctAnswer;
    String baseballGameMessageForUser;

    public BaseballGame() throws GameException {
        RandomInputNumber randomInputNumber = new RandomInputNumber();
        this.correctAnswer = randomInputNumber.getInputNumber();
        this.gameStatus = BaseballGameStatus.NOTING;
    }

    @Override
    public void gameProcess(InputNumber inputNumber) throws GameException {
        GameNumberCompareResult gameNumberCompareResult = GameNumberGroupsHelper.compareEachGameGroup(correctAnswer, inputNumber.getInputNumber());
        if (isScoreSameGameStatus(gameNumberCompareResult.getNumberAndDigitSameScore(), BaseballGameStatus.WIN)) return;
        if (isScoreSameGameStatus(gameNumberCompareResult.getAllCompareScore(), BaseballGameStatus.NOTING)) return;
        setGameStatusAndMessage(BaseballGameStatus.HINT, gameNumberCompareResult);
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

    private void setGameStatusAndMessage(BaseballGameStatus messageForUser, GameNumberCompareResult gameNumberCompareResult) {
        gameStatus = messageForUser;
        baseballGameMessageForUser = messageForUser.getMessageForUser(gameNumberCompareResult);
    }

    public BaseballGameStatus getGameStatus() {
        return gameStatus;
    }
}

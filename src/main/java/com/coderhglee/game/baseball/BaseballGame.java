package com.coderhglee.game.baseball;

import com.coderhglee.game.domain.Game;
import com.coderhglee.game.domain.GameGroupsCompareResult;
import com.coderhglee.game.number.GameNumberGroups;
import com.coderhglee.game.number.GameNumberGroupsHelper;
import com.coderhglee.game.number.InputNumber;
import com.coderhglee.game.number.RandomInputNumber;
import com.coderhglee.game.exception.GameException;

public class BaseballGame implements Game {
    BaseballGameStatus gameStatus;
    GameNumberGroups correctAnswer;
    String baseballGameMessageForUser;

    public BaseballGame(GameNumberGroups correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void setGameUI() {

    }

    @Override
    public void sendMessageToUserInterface(String userMessage) {
    }

    @Override
    public void gameStart() throws GameException {
        InputNumber inputNumber = new RandomInputNumber();
        correctAnswer = inputNumber.getInputNumber();
    }

    @Override
    public void gameProcess(InputNumber inputNumber) throws GameException {
        GameGroupsCompareResult gameGroupsCompareResult = GameNumberGroupsHelper.compareEachGameGroup(correctAnswer, inputNumber.getInputNumber());
        if (isScoreSameGameStatus(gameGroupsCompareResult.getNumberAndDigitSameScore(),BaseballGameStatus.WIN)) return;
        if (isScoreSameGameStatus(gameGroupsCompareResult.getAllCompareScore(),BaseballGameStatus.NOTING)) return;
        setGameStatusAndMessage(BaseballGameStatus.HINT, gameGroupsCompareResult);
    }

    @Override
    public String getGameResultMessage() {
        return this.baseballGameMessageForUser;
    }

    @Override
    public void endGame() {

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

    private void setGameStatusAndMessage(BaseballGameStatus messageForUser, GameGroupsCompareResult gameGroupsCompareResult) {
        gameStatus = messageForUser;
        baseballGameMessageForUser = messageForUser.getMessageForUser(gameGroupsCompareResult);
    }

    public BaseballGameStatus getGameStatus() {
        return gameStatus;
    }
}

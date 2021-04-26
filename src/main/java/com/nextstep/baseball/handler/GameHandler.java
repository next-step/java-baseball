package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.GameCode;

public class GameHandler {
    private final GameUiHandler gameUiHandler = new GameUiHandler();
    private final GameLogicHandler gameLogicHandler = new GameLogicHandler();

    private int randomNum;
    private int code;

    public void startGame() {
        code = GameCode.START.getCode();
        randomNum = gameLogicHandler.makeRandomNumberForGame();

        while (code > 0) {
            String input = gameUiHandler.getInput();
            int[] guessResult = gameLogicHandler.checkStrikesAndBalls(randomNum, gameLogicHandler.validateAndReturnInput(input));
            code = gameUiHandler.printResultAndCheckContinue(guessResult);
            checkCode();
        }
    }

    private void checkCode() {
        if (code == GameCode.NEW_GAME.getCode()) {
            this.randomNum = gameLogicHandler.makeRandomNumberForGame();
            this.code = GameCode.CONTINUE.getCode();
        }
    }

}

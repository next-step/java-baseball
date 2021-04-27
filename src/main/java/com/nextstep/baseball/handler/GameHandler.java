package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.ErrorMessages;
import com.nextstep.baseball.enums.GameCode;

public class GameHandler {
    private final GameUiHandler gameUiHandler = new GameUiHandler();
    private final GameLogicHandler gameLogicHandler = new GameLogicHandler();

    private int randomNum;
    private int code;

    public void startGame() {
        initCodeAndRandomNum();

        while (code > 0) {
            executeGame();
        }
    }

    private void initCodeAndRandomNum() {
        code = GameCode.START.getCode();
        randomNum = gameLogicHandler.makeRandomNumberForGame();
    }

    private void executeGame() {
        String input = gameUiHandler.getInput();
        int num = gameLogicHandler.validateAndReturnInput(input);

        ErrorMessages errorMessages = ErrorMessages.findByCode(num);
        if (errorMessages != null) {
            handleError(errorMessages);
            return;
        }

        executeCheckStrikeAndBallLogic(num);
    }

    private void checkCode() {
        if (code == GameCode.NEW_GAME.getCode()) {
            this.randomNum = gameLogicHandler.makeRandomNumberForGame();
            this.code = GameCode.CONTINUE.getCode();
        }
    }

    private void handleError(ErrorMessages errorMessages) {
        System.out.println(errorMessages.getMessage());
        this.code = GameCode.EXIT.getCode();
    }

    private void executeCheckStrikeAndBallLogic(int num) {
        int[] guessResult = gameLogicHandler.checkStrikesAndBalls(randomNum, num);
        code = gameUiHandler.printResultAndCheckContinue(guessResult);
        checkCode();
    }
}

package baseball.controller;

import baseball.config.BaseballConfig;
import baseball.constants.BaseballConstant;
import baseball.model.BaseballNumber;
import baseball.model.BaseballResult;

public abstract class BaseballControllerTemplate {

    public void run() {
        this.run(BaseballConfig.getDefaultConfig());
    }

    public void run(BaseballConfig config) {
        do {
            // 1. Init Game
            this.initGame(config.getSize(), config.getRadix());

            // 2. Game Process Start
            BaseballResult result = this.startGame(config.getTryCount());

            // 3. Print Game Final Result
            this.printGameResult(result);

            // 4. Ask Continue to play game
        } while (this.askReGame());
    }

    private void initGame() {
        this.initGame(BaseballConstant.DEFAULT_NUMBERS_SIZE, BaseballConstant.DEFAULT_NUMBER_RADIX);
    }

    private BaseballResult startGame() {
        // Infinite Loop
        BaseballResult result;
        do {
            // Unit Game Process
            result = this.unitProcessGame();
        } while (!result.isComplete());

        return result;
    }

    private BaseballResult startGame(int tryCount) {
        if (tryCount <= 0) {
            return this.startGame();
        }

        BaseballResult result = null;

        // Finite Loop
        for (int i = 0; i < tryCount && (result == null || !result.isComplete()); i++) {
            // Unit Game Process
            result = this.unitProcessGame();
        }

        return result;
    }

    private BaseballResult unitProcessGame() {
        try {
            // 1. User Input Read
            BaseballNumber baseballNumber = this.readInputBaseballNumber();

            // 2. Input, Answer Compare & Check
            BaseballResult baseballResult = this.checkTrial(baseballNumber);

            // 3. Print Check Result
            this.printBaseballResult(baseballResult);

            // 4. Return Check Result
            return baseballResult;
        } catch (RuntimeException e) {
            // Print Exception
            this.printExceptionInProcess(e);

            // Return Failed Result
            return BaseballResult.createFailedResult();
        }
    }

    abstract protected void initGame(int size, int radix);

    abstract protected BaseballNumber readInputBaseballNumber();

    abstract protected BaseballResult checkTrial(BaseballNumber baseballNumber);

    abstract protected void printBaseballResult(BaseballResult baseballResult);

    abstract protected void printGameResult(BaseballResult baseballResult);

    abstract protected void printExceptionInProcess(Exception e);

    abstract protected boolean askReGame();
    
}

package baseball.controller;

import baseball.config.BaseballConfig;
import baseball.model.BaseballNumber;
import baseball.model.BaseballResult;

// TODO: remove baseballNumber, BaseballResult dependency in Controller
public abstract class BaseballControllerTemplate {

    public void run() {
        this.run(BaseballConfig.builder().build());
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

    public void initGame() {
        this.initGame(BaseballNumber.DEFAULT_NUMBERS_SIZE, BaseballNumber.DEFAULT_NUMBER_RADIX);
    }

    public BaseballResult startGame() {
        // Infinite Loop
        BaseballResult result;
        do {
            // Unit Game Process
            result = processGame();
        } while (!result.isComplete());

        return result;
    }

    public BaseballResult startGame(int tryCount) {
        if (tryCount <= 0) {
            return this.startGame();
        }

        BaseballResult result = null;

        // Finite Loop
        for (int i = 0; i < tryCount; i++) {
            // Unit Game Process
            result = processGame();

            if (result.isComplete()) {
                return result;
            }
        }

        return result;
    }

    public BaseballResult processGame() {
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

    abstract public void initGame(int size, int radix);

    abstract public BaseballNumber readInputBaseballNumber();

    abstract public BaseballResult checkTrial(BaseballNumber baseballNumber);

    abstract public void printBaseballResult(BaseballResult baseballResult);

    abstract public void printGameResult(BaseballResult baseballResult);

    abstract public void printExceptionInProcess(Exception e);

    abstract public boolean askReGame();


}

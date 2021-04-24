package baseball.configures;

import baseball.models.*;

public class AppConfig {


    Calculator calculator() {
        return new Calculator();
    }

    RandomNumGenerator randomNumGenerator() {
        return new RandomNumGenerator();
    }

    NumValidChecker numValidChecker() {
        return new NumValidChecker();
    }

    PrintGenerator printGenerator() {
        return new PrintGenerator(numValidChecker(), calculator());
    }

    public BaseBallNumGame baseBallNumGame() {
        return new BaseBallNumGame(randomNumGenerator(), printGenerator());
    }

}

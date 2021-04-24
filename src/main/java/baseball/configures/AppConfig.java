package baseball.configures;

import baseball.models.*;

public class AppConfig {


    public Calculator calculator() {
        return new Calculator();
    }

    public RandomNumGenerator randomNumGenerator() {
        return new RandomNumGenerator();
    }

    public NumValidChecker numValidChecker() {
        return new NumValidChecker();
    }

    public PrintGenerator printGenerator() {
        return new PrintGenerator(numValidChecker(), calculator());
    }

    public BaseBallNumGame baseBallNumGame() {
        return new BaseBallNumGame(randomNumGenerator(), printGenerator());
    }

}

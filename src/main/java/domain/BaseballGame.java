package domain;

public class BaseballGame {
    private final BaseballNumbers baseballNumbers;

    BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballGame init(BaseballNumbersGenerator generator) {
        return new BaseballGame(generator.generate());
    }

    public BaseballResult play(BaseballNumbers playerBalls) {
        int numberOfMatchedNumbers = baseballNumbers.countMatchNumbers(playerBalls);

        if (numberOfMatchedNumbers == 0) {
            return BaseballResult.makeFourBall();
        }

        return BaseballResult.of(numberOfMatchedNumbers, 0);
    }
}

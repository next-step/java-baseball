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
        return calculateResult(
                baseballNumbers.countMatchNumbers(playerBalls),
                baseballNumbers.countExactMatch(playerBalls)
        );
    }

    private BaseballResult calculateResult(int numberOfMatchedNumbers, int numberOfStrikes) {
        if (numberOfMatchedNumbers == 0) {
            return BaseballResult.makeFourBall();
        }

        int numberOfBalls = numberOfMatchedNumbers - numberOfStrikes;

        return BaseballResult.of(numberOfBalls, numberOfStrikes);
    }
}

package domain;

public class BaseballGame {
    private boolean finished;
    private final BaseballNumbers baseballNumbers;

    BaseballGame(BaseballNumbers baseballNumbers) {
        this.finished = false;
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballGame init(BaseballNumbersGenerator generator) {
        return new BaseballGame(generator.generate());
    }

    public BaseballResult play(BaseballNumbers playerBalls) {
        BaseballResult baseballResult = calculateResult(
                baseballNumbers.countMatchNumbers(playerBalls),
                baseballNumbers.countExactMatch(playerBalls)
        );

        checkEndOfGame(baseballResult);

        return baseballResult;
    }

    public boolean isFinished() {
        return finished;
    }

    private BaseballResult calculateResult(int numberOfMatchedNumbers, int numberOfStrikes) {
        if (numberOfMatchedNumbers == 0) {
            return BaseballResult.makeFourBall();
        }

        int numberOfBalls = numberOfMatchedNumbers - numberOfStrikes;

        return BaseballResult.of(numberOfBalls, numberOfStrikes);
    }

    private void checkEndOfGame(BaseballResult baseballResult) {
        if (baseballResult.getStrikeCount() == 3) {
            finished = true;
        }
    }
}

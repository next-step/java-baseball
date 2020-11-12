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
        System.out.println(baseballNumbers);
        int numberOfMatchedNumbers = baseballNumbers.countMatchNumbers(playerBalls);

        if (numberOfMatchedNumbers == 0) {
            return BaseballResult.makeFourBall();
        }

        int numberOfStrikes = baseballNumbers.countExactMatch(playerBalls);
        int numberOfBalls = numberOfMatchedNumbers - numberOfStrikes;

        return BaseballResult.of(numberOfBalls, numberOfStrikes);
    }
}

package baseball.domain;


public class GameResult {
    private BaseballNumberGroup playerNumbers;
    private BaseballNumberGroup computerNumbers;

    private int numberOfStrikes;
    private int numberOfBalls;

    private GameResult(BaseballNumberGroup playerNumbers, BaseballNumberGroup computerNumbers,
                       int numberOfStrikes, int numberOfBalls) {
        this.playerNumbers = playerNumbers;
        this.computerNumbers = computerNumbers;
        this.numberOfStrikes = numberOfStrikes;
        this.numberOfBalls = numberOfBalls;
    }

    public static GameResult of(BaseballNumberGroup playerNumbers, BaseballNumberGroup computerNumbers,
                                int numberOfStrikes, int numberOfBalls) {
        return new GameResult(playerNumbers, computerNumbers, numberOfStrikes, numberOfBalls);
    }

    public boolean isAllStrikes() {
        return this.numberOfStrikes == GameRule.NUMBER_OF_DIGITS;
    }

    @Override
    public String toString() {
        if (numberOfStrikes == 0 && numberOfBalls == 0) {
            return "낫싱";
        }
        if (numberOfStrikes == GameRule.NUMBER_OF_DIGITS) {
            return numberOfStrikes + "스트라이크";
        }
        return numberOfStrikes + "스트라이크 "
                + numberOfBalls + "볼";
    }

    public int getNumberOfStrikes() {
        return numberOfStrikes;
    }

    public int getNumberOfBalls() {
        return numberOfBalls;
    }
}

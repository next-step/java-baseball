package baseball.domain;

public class Opponent {
    private final NumberGenerateStrategy numberGenerateStrategy;

    public Opponent(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public BallNumbers generateBallNumbers() {
        return BallNumbers.from(numberGenerateStrategy.generate());
    }
}

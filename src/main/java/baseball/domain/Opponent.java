package baseball.domain;

public class Opponent {
    private final NumberGenerateStrategy numberGenerateStrategy;

    public Opponent(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public BaseBallNumbers generateBallNumbers() {
        return BaseBallNumbers.from(numberGenerateStrategy.generate());
    }
}

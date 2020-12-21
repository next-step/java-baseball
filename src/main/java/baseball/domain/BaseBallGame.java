package baseball.domain;

public class BaseBallGame {
    private final BaseBallNumbers opponentNumbers;
    private boolean end;

    private BaseBallGame(BaseBallNumbers opponentNumbers, boolean end) {
        this.opponentNumbers = opponentNumbers;
        this.end = end;
    }

    public static BaseBallGame initialize(NumberGenerateStrategy numberGenerateStrategy) {
        BaseBallNumbers numbers = BaseBallNumbers.from(numberGenerateStrategy.generate());
        return new BaseBallGame(numbers, false);
    }

    public GameResult guess(BaseBallNumbers numbers) {
        checkProceeding();

        GameResult result = GameResult.of(numbers, opponentNumbers);
        if (result.isThreeStrike()) {
            end = true;
        }
        return result;
    }

    private void checkProceeding() {
        if (end) {
            throw new IllegalStateException("이미 종료된 게임입니다");
        }
    }

    public boolean isEnd() {
        return end;
    }
}

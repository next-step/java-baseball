package baseball.domain;

public class BaseBallGame {
    private final BallNumbers opponentNumbers;
    private boolean end;

    private BaseBallGame(BallNumbers opponentNumbers, boolean end) {
        this.opponentNumbers = opponentNumbers;
        this.end = end;
    }

    public static BaseBallGame initialize(Opponent opponent) {
        return new BaseBallGame(opponent.generateBallNumbers(), false);
    }

    public GameResult guess(BallNumbers numbers) {
        GameResult result = GameResult.of(numbers, opponentNumbers);
        if (result.isThreeStrike()) {
            end = true;
        }
        return result;
    }

    public boolean isEnd() {
        return end;
    }
}

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

    public boolean isEnd() {
        return end;
    }
}

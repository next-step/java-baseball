package baseball.ui;

import baseball.domain.GameResult;

public class GameResultResponse {
    private final boolean nothing;
    private final boolean end;
    private final int strike;
    private final int ball;

    private GameResultResponse(boolean nothing, boolean end, int strike, int ball) {
        this.nothing = nothing;
        this.end = end;
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResultResponse from(GameResult gameResult) {
        return new GameResultResponse(
                gameResult.isNothing(),
                gameResult.isThreeStrike(),
                gameResult.getStrike(),
                gameResult.getBall()
        );
    }

    public boolean isNothing() {
        return nothing;
    }

    public boolean isEnd() {
        return end;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

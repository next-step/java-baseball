package baseball.game.domain.game;

import baseball.game.domain.Balls;

public class BaseBallGame {

    private final Balls gameBalls;

    private BaseBallGame(Balls balls) {
        this.gameBalls = balls;
    }

    public static BaseBallGame createGame(Balls randomBalls) {
        return new BaseBallGame(randomBalls);
    }

    public BaseBallGameResultType getResult(Balls inputBalls) {
        BaseBallGameResult gameResult = new BaseBallGameResult();
        gameResult.result(gameBalls, inputBalls);

        return BaseBallGameResultType.find(gameResult);
    }
}

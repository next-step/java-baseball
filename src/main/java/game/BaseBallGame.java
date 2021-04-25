package game;

import java.util.Scanner;

public class BaseBallGame {
    private Referee referee;

    public Referee getReferee() {
        return referee;
    }

    public void startGame() {
        startGame(new Hitter());
    }

    private void startGame(Hitter hitter) {
        this.referee = new Referee();
        GameResult gameResult;

        do {
            gameResult = getReferee().getGameResult(new Pitcher(), hitter);
            gameResult.printGameResult();
        } while (!gameResult.isCorrect());
    }
}

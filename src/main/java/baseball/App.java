package baseball;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.Score;
import baseball.view.Continuable;
import baseball.view.InputView;
import baseball.view.OutputView;

public class App {
    public static void main(String[] args) {
        do {
            Game game = new Game();

            playGame(game);
        }while(InputView.moreGame() == Continuable.CONTINUE);
    }

    private static void playGame(Game game) {
        Balls balls = null;
        Score match = null;

        do {
            balls = InputView.balls();
            match = game.match(balls);

            OutputView.gameStatus(match);
        }while(match.isNotEndGame());
    }
}

package game.baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hitter hitter = new Hitter();
        Umpire umpire = new Umpire();
        Pitcher pitcher = new Pitcher();
        GameController gameController = new GameController(umpire, pitcher, hitter);

        boolean isFinished = false;

        while (!isFinished) {
            gameController.resetHittngNumbers();
            gameController.resetBaseballCounts();
            gameController.playGame();
            isFinished = gameController.restartGame();
        }
    }
}

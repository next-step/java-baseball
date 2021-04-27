package baseballgame;

import baseballgame.game.Game;
import baseballgame.game.Player;

public class GameController {

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void run() {
        final Player player = new Player();
        boolean isRunning = true;
        while (isRunning) {
            final Game game = new Game();
            player.play(game);
            isRunning = player.wantToRerun();
        }
    }

}

package game;

public class GameRunner {
    public static void run(Game game) {
        game.start();

        while (game.isPlaying()) {
            game.run();
        }

        game.end();
    }
}

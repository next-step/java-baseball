package baseballgame.domain.game;

public class GameParser {
    private static final GameParser PARSER = new GameParser();
    private static final int CONTINUE = 1;

    private GameParser() {
    }

    public static GameParser getInstance() {
        return PARSER;
    }

    public boolean whetherRestartGame(final String input) {
        try {
            final int whether = Integer.parseInt(input);

            return whether == CONTINUE;
        } catch (Exception e) {
            return false;
        }
    }
}

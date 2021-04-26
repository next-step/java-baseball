public class Application {
    private static final int DEFAULT_NUMBER_SIZE = 3;

    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame();

        while (game.canPlay()) {
            game.init(DEFAULT_NUMBER_SIZE);
            game.inputNumberAndGuess();
            game.afterSuccess();
        }

        game.exit();
    }
}

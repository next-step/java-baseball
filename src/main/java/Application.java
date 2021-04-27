public class Application {
    private static final int DEFAULT_NUMBER_SIZE = 3;

    public static void main(String[] args) {
        Player player = new Player();
        InputHelper inputHelper = new InputHelper();

        while (player.isReady()) {
            BaseBallGame game = new BaseBallGame(player, inputHelper, DEFAULT_NUMBER_SIZE);
            game.start();
        }

        inputHelper.destroy();
    }
}

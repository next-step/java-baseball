
public class GameMain {

    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();
        boolean isContinueGame = true;
        while (isContinueGame) {
            isContinueGame = gameHandler.playGame();
        }
    }
}

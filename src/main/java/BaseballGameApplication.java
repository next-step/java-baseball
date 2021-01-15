public class BaseballGameApplication {

    public static void main(String[] args) {
        GameManager gameManager = ApplicationContext.getGameManager();
        boolean playerWantsToPlayNewGame;
        do {
            playerWantsToPlayNewGame = gameManager.start();
        } while (playerWantsToPlayNewGame);
    }
}

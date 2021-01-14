public class BaseballGameApplication {

    public static void main(String[] args) {
        GameManager gameManager = ApplicationContext.getGameManager();
        gameManager.start();
    }
}

public class BaseballGameApplication {

    public static void main(String[] args) {
        GameManager gameManager = ApplicationContext.getGameManager();
        // TODO: 게임을 새로 시작할 것인지 묻기
        gameManager.start();
    }
}

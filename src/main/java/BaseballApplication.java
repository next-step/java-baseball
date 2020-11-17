import com.baseballgame.BaseballGame;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballGame baseballGame;
        do {
            baseballGame = new BaseballGame();
            baseballGame.start();
        } while (baseballGame.isRunning());
    }
}

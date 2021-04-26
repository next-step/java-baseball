package baseball;

public class BaseballMainApp {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        while (!baseballGame.isFinished()) {
            baseballGame.startGame();
        }
    }

}

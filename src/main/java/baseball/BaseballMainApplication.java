package baseball;

public class BaseballMainApplication {
    public static void main(String[] args) {
        BaseballGame baseball = new BaseballGame();
        do {
            baseball.startGame();
        } while (baseball.getRestart() == 1);
    }
}

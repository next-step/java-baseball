public class BaseballGame {
    public static final int DEFAULT_LEN = 3;

    private int maxLen;

    public BaseballGame() {
        this(DEFAULT_LEN);
    }

    public BaseballGame(int maxLen) {
        this.maxLen = maxLen;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

    }
}

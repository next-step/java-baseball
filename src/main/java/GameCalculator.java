public class GameCalculator {
    private int maxLen;

    public GameCalculator() {
        this(BaseballGame.DEFAULT_LEN);
    }

    public GameCalculator(int maxLen) {
        this.maxLen = maxLen;
    }
}

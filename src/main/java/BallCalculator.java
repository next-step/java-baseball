public class BallCalculator {
    private int maxLen;

    public BallCalculator() {
        this(BaseballGame.DEFAULT_LEN);
    }

    public BallCalculator(int maxLen) {
        this.maxLen = maxLen;
    }
}

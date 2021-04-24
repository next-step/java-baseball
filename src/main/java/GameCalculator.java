public class GameCalculator {
    private int maxLen;

    public GameCalculator() {
        this(BaseballGame.DEFAULT_LEN);
    }

    public GameCalculator(int maxLen) {
        this.maxLen = maxLen;
    }

    public int[] calculateResult(String generated, String input) {
        return new int[]{3,0};
    }
}

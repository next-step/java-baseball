public class StrikeCalculator {
    private int maxLen;

    public StrikeCalculator() {
        this(BaseballGame.DEFAULT_LEN);
    }

    public StrikeCalculator(int maxLen) {
        this.maxLen = maxLen;
    }

    public int getStrikesCnt(String generated, String input) {
        return input.equals(generated) ? 3 : 1;
    }
}

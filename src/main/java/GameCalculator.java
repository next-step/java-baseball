public class GameCalculator {
    private int maxLen;
    private StrikeCalculator strikeCalculator;
    private BallCalculator ballCalculator;

    public GameCalculator() {
        this(BaseballGame.DEFAULT_LEN);
        strikeCalculator = new StrikeCalculator(BaseballGame.DEFAULT_LEN);
        ballCalculator = new BallCalculator(BaseballGame.DEFAULT_LEN);
    }

    public GameCalculator(int maxLen) {
        this.maxLen = maxLen;
        strikeCalculator = new StrikeCalculator(maxLen);
        ballCalculator = new BallCalculator(maxLen);
    }

    public int[] calculateResult(String generated, String input) {
        int strikescnt = strikeCalculator.getStrikesCnt(generated, input);
        int ballscnt = ballCalculator.getBallsCnt(generated, input);
        return new int[]{strikescnt, ballscnt};
    }
}

package numberBaseball;

public class MatchResult {
    private int strikes;
    private int balls;

    public MatchResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}

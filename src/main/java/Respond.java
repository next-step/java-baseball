public class Respond {

    private final int strikes;
    private final int balls;

    public Respond(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        String ret = "";
        if (strikes > 0) ret += (strikes + " 스트라이크 ");
        if (balls > 0) ret += (balls + " 볼 ");
        if (ret.equals("")) return "낫싱";
        return ret;
    }
}

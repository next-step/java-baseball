public class BallCalculator {
    private int maxLen;

    public BallCalculator() {
        this(BaseballGame.DEFAULT_LEN);
    }

    public BallCalculator(int maxLen) {
        this.maxLen = maxLen;
    }

    public int chkBall(String s1, String s2, int index) {
        return !(s1.charAt(index) == s2.charAt(index)) && s1.contains(s2.charAt(index) + "") ? 1 : 0;
    }

    public int getBallsCnt(String generated, String input) {
        int cnt = 0;

        for(int i=0;i<maxLen;i++)
            cnt += chkBall(generated, input, i);

        return cnt;
    }
}

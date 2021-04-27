public class StrikeCalculator {
    private int maxLen;

    public StrikeCalculator() {
        this(BaseballGame.DEFAULT_LEN);
    }

    public StrikeCalculator(int maxLen) {
        this.maxLen = maxLen;
    }

    public int compareStr(char s1, char s2) {
        return s1 == s2 ? 1 : 0;
    }

    public int getStrikesCnt(String generated, String input) {
        int cnt = 0;

        for(int i=0;i<maxLen;i++)
            cnt += compareStr(generated.charAt(i), input.charAt(i));

        return cnt;
    }
}

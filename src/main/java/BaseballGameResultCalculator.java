public class BaseballGameResultCalculator {
    private int maxLen;

    private BaseballGameResultCalculator(){
        this(BaseballGame.DEFAULT_LEN);
    }
    public BaseballGameResultCalculator(int maxLen){
        this.maxLen = maxLen;
    }

    public int getStrikesCnt(String createdStr, String inputStr) {
        int count = 0;

        for (int i=0; i<maxLen; i++)
            if (isStrikeAtIndex(createdStr,inputStr,i))
                count += 1;

        return count;
    }

    private boolean isStrikeAtIndex(String createdStr, String inputStr, int index) {
        return createdStr.charAt(index) == inputStr.charAt(index);
    }

    public int getBallsCnt(String createdStr, String inputStr) {
        int cnt = 0;

        for (int i=0; i<maxLen; i++)
            if (isBallAtIndex(createdStr, inputStr, i))
                cnt += 1;

        return cnt;
    }

    private boolean isBallAtIndex(String createdStr, String inputStr, int index) {
        return !(isStrikeAtIndex(createdStr, inputStr, index)) && createdStr.contains(inputStr.charAt(index)+"");
    }

    public int[] calculateGameResult(String createdStr, String inputStr){
        int strikes = getStrikesCnt(createdStr, inputStr);
        int balls = getBallsCnt(createdStr, inputStr);
        return new int[]{ strikes, balls };
    }
}

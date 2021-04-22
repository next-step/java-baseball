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
            if (createdStr.charAt(i) == inputStr.charAt(i))
                count += 1;

        return count;
    }

    public int getBallsCnt(String createdStr, String inputStr) {
        return 0;
    }
}

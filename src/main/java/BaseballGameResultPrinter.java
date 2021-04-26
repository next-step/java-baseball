public class BaseballGameResultPrinter {

    private int maxLen;

    public BaseballGameResultPrinter(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public BaseballGameResultPrinter(int maxLen){
        this.maxLen = maxLen;
    }

    public String baseballGameResultPrint(int[] result) {
        if (result[0] == result[1] && result[0] == 0)
            return "낫싱";
        if (result[1] == 0)
            return result[0] + " 스트라이크";
        if (result[0] == 0)
            return result[1] + " 볼";
        return result[0] + " 스트라이크 " + result[1] + " 볼";
    }

}

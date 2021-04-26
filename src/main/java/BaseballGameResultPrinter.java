public class BaseballGameResultPrinter {

    private int maxLen;

    public BaseballGameResultPrinter(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public BaseballGameResultPrinter(int maxLen){
        this.maxLen = maxLen;
    }

    public String baseballGameResultPrint(int[] result) {
        return result[0] == result[1] && result[0] == 0 ? "낫싱" : result[0] + " 스트라이크";
    }

}

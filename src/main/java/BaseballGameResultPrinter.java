public class BaseballGameResultPrinter {

    private int maxLen;

    public BaseballGameResultPrinter(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public BaseballGameResultPrinter(int maxLen){
        this.maxLen = maxLen;
    }

}

package baseball.game;

public class BaseBallResult {

    private boolean isEnd;
    private String printResult;

    public BaseBallResult(boolean isEnd, String printResult) {
        this.isEnd = isEnd;
        this.printResult = printResult;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public String getPrintResult() {
        return printResult;
    }
}

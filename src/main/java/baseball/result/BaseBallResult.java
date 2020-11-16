package baseball.result;

public class BaseBallResult {

    private boolean isPlay;
    private String printResult;

    public BaseBallResult(boolean isPlay, String printResult) {
        this.isPlay = isPlay;
        this.printResult = printResult;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public String getPrintResult() {
        return printResult;
    }
}

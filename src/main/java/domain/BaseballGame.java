package domain;

public class BaseballGame {
    private static final BaseballRecord baseballRecord = new BaseballRecord();
    private final int answer;

    public BaseballGame(int answer) {
        this.answer = answer;
    }

    public void playInning(int tryNumber) {
//        int strike = checkStrike(answer, tryNumber);
//        int ball = checkBall(answer, tryNumber);
        int strike = 1;
        int ball = 1;

        Inning inning = new Inning(tryNumber, strike, ball);
        baseballRecord.recordInningResult(inning);
    }

    public BaseballRecord getBaseballRecord() {
        return this.baseballRecord;
    }
}

package baseball.result;

public class BaseBallRulResult {
    public static BaseBallResult rulResult(int strike, int ball) {
        String result = "";

        if (strike > 0) {
            result += strike + " 스트라이크 ";
        }
        if (ball > 0) {
            result += ball + "볼";
        }
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }

        return new BaseBallResult(!(strike == 3), result);
    }
}

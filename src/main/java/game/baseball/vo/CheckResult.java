package game.baseball.vo;

import game.baseball.constant.BaseballConfig;
import game.baseball.constant.BaseballResult;

public class CheckResult {
    private int strike = 0;
    private int ball = 0;

    public void addResult(BaseballResult baseBallResult) {
        if (baseBallResult.equals(BaseballResult.STRIKE)) {
            strike++;
            return;
        }

        if (baseBallResult.equals(BaseballResult.BALL)) {
            ball++;
        }
    }

    public String getResultString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            sb.append(strike).append(" 스트라이크");
        }

        if (ball != 0) {
            sb.append(" ").append(ball).append(" 볼");
        }

        return sb.toString().trim();
    }

    public boolean isGameFinish() {
        return strike == BaseballConfig.ANSWER_COUNT;
    }
}

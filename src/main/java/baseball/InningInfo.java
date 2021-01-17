package baseball;

public class InningInfo {
    private static final String NOTHING_MSG = "낫싱";
    private static final String BALL_MSG = "볼";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String DELIMITER_MSG = " ";
    private static final String END_MSG = "개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private final int strike;
    private final int ball;
    private final int out;

    public InningInfo(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public String playMessage() {
        StringBuilder msg = new StringBuilder();

        if (ball == 0 && strike == 0) {
            msg.append(NOTHING_MSG);
        }
        if (ball > 0) {
            msg.append(ball).append(BALL_MSG);
        }
        if (ball > 0 && strike > 0) {
            msg.append(DELIMITER_MSG);
        }
        if (strike > 0) {
            msg.append(strike).append(STRIKE_MSG);
        }

        return msg.append("\n").toString();
    }

    public String endMessage() {
        StringBuilder msg = new StringBuilder();

        if (strike == out) {
            msg.append(out).append(END_MSG);
        }

        return msg.toString();
    }
}

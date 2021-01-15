package baseball;

public class UserOutput {
    private static final String NOTHING_MSG = "낫싱";
    private static final String BALL_MSG = "볼";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String DELIMITER_MSG = " ";
    private static final String FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printInfo(int ball, int strike) {
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

        System.out.println(msg);
    }

    public void printFinish() {
        System.out.println(FINISH_MSG);
    }
}

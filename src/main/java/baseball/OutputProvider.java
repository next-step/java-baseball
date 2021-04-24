package baseball;

public class OutputProvider {
    public final static String REQUEST_INPUT = "숫자를 입력해주세요 :";
    public final static String RESULT_NOTHING = "낫싱";
    public final static String RESULT_STRIKE = " 스트라이크";
    public final static String RESULT_BALL = " 볼";
    public final static String RESULT_COMPLETE = "3개의 숫자를 모두 맞히셨습니다!\n게임 종료게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private StringBuffer output = new StringBuffer();
    public String flushOutput() {
        String out = this.output.toString();
        output.setLength(0);
        return out;
    }

    public void appendRequestInput() {
        output.append(REQUEST_INPUT);
    }

    public void appendNothing() {
        output.append(RESULT_NOTHING);
    }

    public void appendComplete() {
        output.append(RESULT_COMPLETE);
    }

    public void appendResultOutput(int strikeCount, int ballCount) {
        appendStrikeOutput(strikeCount);
        appendBallOutput(ballCount, strikeCount > 0);
        appendNewLineOutput();
    }

    private void appendNewLineOutput() {
        output.append("\n");
    }

    private void appendBallOutput(int ballCount, boolean hasStrike) {
        if (ballCount == 0) {
            return;
        }

        if (hasStrike) {
            output.append(" ");
        }

        output.append(ballCount + RESULT_BALL);
    }

    private void appendStrikeOutput(int strikeCount) {
        if (strikeCount == 0) {
            return;
        }

        output.append(strikeCount + RESULT_STRIKE);
    }
}

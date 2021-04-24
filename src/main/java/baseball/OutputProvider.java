package baseball;

import static baseball.GameModel.*;

public class OutputProvider {
    private StringBuffer output = new StringBuffer();
    public String flushOutput() {
        String output = this.output.toString();
        this.output.setLength(0);
        return output;
    }

    public void appendRequestInput() {
        this.output.append(REQUEST_INPUT);
    }

    public void appendNothing() {
        this.output.append(RESULT_NOTHING);
    }

    public void appendComplete() {
        this.output.append(RESULT_COMPLETE);
    }

    public void appendResultOutput(int strikeCount, int ballCount) {
        appendStrikeOutput(strikeCount);
        appendBallOutput(ballCount, strikeCount > 0);
        appendNewLineOutput();
    }

    private void appendNewLineOutput() {
        this.output.append("\n");
    }

    private void appendBallOutput(int ballCount, boolean hasStrike) {
        if (ballCount == 0) {
            return;
        }

        if (hasStrike) {
            this.output.append(" ");
        }

        this.output.append(ballCount + RESULT_BALL);
    }

    private void appendStrikeOutput(int strikeCount) {
        if (strikeCount == 0) {
            return;
        }

        this.output.append(strikeCount + RESULT_STRIKE);
    }
}

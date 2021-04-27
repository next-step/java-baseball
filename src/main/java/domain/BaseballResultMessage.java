package domain;

import common.Const;

public class BaseballResultMessage {

    private StringBuilder resultMessage = new StringBuilder();
    private int strikeCount;
    private int ballCount;

    public BaseballResultMessage(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        setResultMessage();
    }

    public StringBuilder getResultMessage() {
        return resultMessage;
    }

    public boolean getStrikeCount() {
        return strikeCount != Const.STRIKE_MAX_NUMBER_SIZE;
    }

    public void setResultMessage() {
        if (strikeCount > 0) {
            resultMessage.append(" Strike: " + strikeCount);
        }

        if (ballCount > 0) {
            resultMessage.append(" Ball: " + ballCount);
        }

        if (strikeCount == 0 && ballCount == 0) {
            resultMessage.append("Nothing");
        }
    }
}

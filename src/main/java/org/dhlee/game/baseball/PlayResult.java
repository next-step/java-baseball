package org.dhlee.game.baseball;

import org.dhlee.game.baseball.constant.BaseballConstant;
import org.dhlee.game.utils.CompareUtils;

public class PlayResult {
    private int strikeCount;
    private int ballCount;

    public PlayResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String getResultMessage() {
        StringBuilder message = new StringBuilder();
        message.append(addResultMessage(this.strikeCount, BaseballConstant.MESSAGE_STRIKE_FORMAT));
        message.append(addResultMessage(this.ballCount, BaseballConstant.MESSAGE_BALL_FORMAT));

        if(CompareUtils.compareNumbers(this.strikeCount, 0) && CompareUtils.compareNumbers(this.ballCount, 0)){
            message.append(BaseballConstant.MESSAGE_NO_COUNT_FORMAT);
        }

        return message.toString();
    }

    private String addResultMessage(int count, String message) {
        if(count > 0) {
            return String.format(message, count);
        }
        return "";
    }

    public boolean getPlayResult(int value) {
        return CompareUtils.compareNumbers(this.strikeCount, value);
    }
}

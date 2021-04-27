package baseball.model;

import baseball.config.BaseballConfig;
import baseball.constants.MessageKey;
import lombok.Getter;

@Getter
public class BaseballResult {
    private int strike;
    private int ball;
    private boolean isComplete;
    private int size;
    private int radix;
    private BaseballNumber[] baseballNumbers;

    public static BaseballResult calcResult(BaseballNumber left, BaseballNumber right) {
        return new BaseballResult(left, right);
    }

    public static BaseballResult createFailedResult() {
        return new BaseballResult(false);
    }

    private BaseballResult(boolean isComplete) {
        this.isComplete = false;
    }

    private BaseballResult(BaseballNumber left, BaseballNumber right) {
        this.size = Math.min(left.getSize(), right.getSize());
        this.radix = Math.min(left.getRadix(), right.getRadix());
        this.baseballNumbers = new BaseballNumber[]{left, right};

        boolean[] isChecked = new boolean[this.radix];

        for (int i = 0; i < this.size; i++) {
            if (left.getNumbers()[i] == right.getNumbers()[i]) {
                this.strike++;
            }

            isChecked[left.getNumbers()[i]] = true;
        }

        if (this.strike == this.size) {
            this.isComplete = true;
            this.ball = 0;
            return;
        }

        for (int i = 0; i < this.size; i++) {
            if (isChecked[right.getNumbers()[i]]
                    && left.getNumbers()[i] != right.getNumbers()[i]) {
                this.ball++;
            }
        }
    }

    public String description() {
        return this.baseballNumbers[0] + "\n" +
                this.baseballNumbers[1] + "\n" +
                this;
    }

    @Override
    public String toString() {
        return toString(BaseballConfig.getDefaultConfig());
    }

    public String toString(BaseballConfig config) {
        if (this.strike == 0 && this.ball == 0) {
            return config.getMessage(MessageKey.noStrikeNoBallResultFormat);
        }

        if (this.strike != 0 && this.ball != 0) {
            return String.format(config.getMessage(MessageKey.strikeAndBallResultFormat), this.strike, this.ball);
        }

        if (this.strike != 0) {
            return String.format(config.getMessage(MessageKey.onlyStrikeResultFormat), this.strike);
        }

        return String.format(config.getMessage(MessageKey.onlyBallResultFormat), this.ball);
    }
}

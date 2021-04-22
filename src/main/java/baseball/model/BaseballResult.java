package baseball.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseballResult {
    private int strike;
    private int ball;
    private boolean isComplete;

    private BaseballNumber[] baseballNumbers;

    public static BaseballResult calcResult(BaseballNumber left, BaseballNumber right) {
        return new BaseballResult(left, right);
    }

    private BaseballResult(BaseballNumber left, BaseballNumber right) {
        baseballNumbers = new BaseballNumber[]{left, right};

        boolean[] isChecked = new boolean[BaseballNumber.DEFAULT_NUMBER_RADIX];

        for (int i = 0; i < BaseballNumber.DEFAULT_NUMBERS_SIZE; i++) {
            if (left.getNumbers()[i] == right.getNumbers()[i]) {
                this.strike++;
            }

            isChecked[left.getNumbers()[i]] = true;
        }

        if (this.strike == BaseballNumber.DEFAULT_NUMBERS_SIZE) {
            this.isComplete = true;
            return;
        }

        for (int i = 0; i < BaseballNumber.DEFAULT_NUMBERS_SIZE; i++) {
            if (isChecked[right.getNumbers()[i]] && left.getNumbers()[i] != right.getNumbers()[i]) {
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
        StringBuilder sb = new StringBuilder();
        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }

        if (this.strike != 0 && this.ball != 0) {
            return String.format("%d 스트라이크 %d 볼", this.strike, this.ball);
        }

        if (this.strike != 0) {
            return String.format("%d 스트라이크", this.strike);
        }

        return String.format("%d 볼", this.ball);
    }
}

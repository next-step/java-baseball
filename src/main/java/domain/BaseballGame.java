package domain;

import java.util.ArrayList;

public class BaseballGame {
    private static final BaseballRecord baseballRecord = new BaseballRecord();
    private final int answer;
    private final ArrayList<Integer> answerGroup;

    public BaseballGame(int answer) {
        this.answer = answer;
        this.answerGroup = makeGroup(this.answer);
    }

    public void playInning(int tryNumber) {
        ArrayList<Integer> tryNumberGroup = makeGroup(tryNumber);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tryNumberGroup.get(i) == this.answerGroup.get(j)) {
                    if (i == j) {
                        strike ++;
                    } else {
                        ball ++;
                    }
                }
            }
        }

        Inning inning = new Inning(tryNumber, strike, ball);
        baseballRecord.recordInningResult(inning);
    }

    public BaseballRecord getBaseballRecord() {
        return this.baseballRecord;
    }

    public ArrayList<Integer> makeGroup(int value) {
        ArrayList<Integer> valueGroup = new ArrayList<>();
        valueGroup.add(value / 100);
        value %= 100;
        valueGroup.add(value / 10);
        value %= 10;
        valueGroup.add(value);

        return valueGroup;
    }
}

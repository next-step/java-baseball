package BaseballGame.domain;

import java.util.ArrayList;
import java.util.Random;

public class BaseballGame {
    private static BaseballRecord baseballRecord;
    private final int answer;
    private final ArrayList<Integer> answerGroup;

    public BaseballGame() {
        this.answer = createAnswer();
        this.answerGroup = makeGroup(this.answer);
        this.baseballRecord = new BaseballRecord();
    }

    public int createAnswer() {
        Random random = new Random();
        int answer = 0;
        ArrayList<Integer> randomBox = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            randomBox.add(i);
        }

        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(randomBox.size());
            answer += randomBox.remove(randomIndex);
            answer *= 10;
        }
        return answer / 10;
    }

    public boolean playInning(int tryNumber) {
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

        if (strike == 3) {
            return true;
        }
        return false;
    }

    public BaseballRecord getBaseballRecord() {
        return this.baseballRecord;
    }

    public Inning getLastResult() {
        return baseballRecord.getLastInning();
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

    public int getNextInningCount() {
        int NEXT = 1;
        return this.getBaseballRecord().getChart().size() + NEXT;
    }
}

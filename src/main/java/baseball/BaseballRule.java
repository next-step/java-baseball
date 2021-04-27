package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballRule {
    private List<Integer> example;
    private List<Integer> answer;
    private int strike = 0;
    private int ball = 0;

    public BaseballRule(List<Integer> example) {
        this.example = example;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public void checkNumbers() {
        checkStrike();
        checkBall();
    }

    private void checkStrike() {
        for(int i = 0; i < 3; i++) {
            strike = example.get(i).compareTo(answer.get(i)) == 0 ? ++strike : strike;
        }
    }

    private void checkBall() {
        List<Integer> compareList = new ArrayList<>();
        compareList.addAll(example);
        compareList.retainAll(answer);
        ball = compareList.size() - strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

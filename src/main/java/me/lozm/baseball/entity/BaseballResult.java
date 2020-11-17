package me.lozm.baseball.entity;

import static me.lozm.baseball.common.CommonUtils.ANSWER_SIZE;

public class BaseballResult {

    private int strike;
    private int ball;

    public BaseballResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public void checkAnswer(String source, String target) {
        for (int i = 0; i < ANSWER_SIZE; i++) {
            strike += isStrike(source, target, i) ? 1 : 0;
            ball += isBall(source, target, i) ? 1 : 0;
        }

        print();
    }

    private boolean isStrike(String source, String target, int index) {
        return source.charAt(index) == target.charAt(index);
    }

    private boolean isBall(String source, String target, int index) {
        return !isStrike(source, target, index) && target.contains(String.valueOf(source.charAt(index)));
    }

    private void print() {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(strike + " 스트라이크, " + ball + " 볼");
    }

}

package model;

import java.util.List;

public class Result {
    private int strike;
    private int ball;

    public Result() {
        resetCount();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void resetCount() {
        this.strike = 0;
        this.ball = 0;
    }

    public void compare(List<Integer> answer, List<Integer> user) {
        resetCount();
        for (int i = 0; i < user.size(); i++) {
            isStrike(answer.get(i), user.get(i));
            isBall(answer, answer.get(i), user.get(i));
        }
    }

    public void isStrike(int ansNum, int userNum) {
        if (ansNum == userNum) {
            this.strike++;
        }
    }

    public void isBall(List<Integer> answer, int ansNum, int userNum) {
        if (ansNum != userNum && answer.contains(userNum)) {
            this.ball++;
        }
    }
}

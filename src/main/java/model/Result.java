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

    /**
     * Reset ball counts.
     */
    public void resetCount() {
        this.strike = 0;
        this.ball = 0;
    }

    /**
     * Compare hidden number and user number to calculate counts.
     * @param answer The list of integer of hidden number.
     * @param user The list of integer of user number.
     */
    public void compare(List<Integer> answer, List<Integer> user) {
        resetCount();
        for (int i = 0; i < user.size(); i++) {
            isStrike(answer.get(i), user.get(i));
            isBall(answer, answer.get(i), user.get(i));
        }
    }

    /**
     * Calculate strike count.
     * @param answerNumber Integer from hidden number.
     * @param userNumber Integer from user number.
     */
    public void isStrike(int answerNumber, int userNumber) {
        if (answerNumber == userNumber) {
            this.strike++;
        }
    }

    /**
     * Calculate ball count. Check the number in hidden number list.
     * @param answer The list of integer of hidden number.
     * @param answerNumber Integer from hidden number.
     * @param userNumber Integer from user number.
     */
    public void isBall(List<Integer> answer, int answerNumber, int userNumber) {
        if (answerNumber != userNumber && answer.contains(userNumber)) {
            this.ball++;
        }
    }
}

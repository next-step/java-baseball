package baseball.domain;

public class BaseballNumbersComparator {

    private static Score score;

    public static Score getScore(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        score = new Score();
        compareBaseballNumbers(computerNumbers, playerNumbers);
        return score;
    }

    private static void compareBaseballNumbers(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        int targetPosition = 0;
        for (BaseballNumber targetNumber : computerNumbers.getValue()) {
            boolean isContains = playerNumbers.contains(targetNumber);
            boolean isSamePosition = (targetPosition == playerNumbers.getPosition(targetNumber));
            calculateScore(isContains, isSamePosition);
            targetPosition++;
        }
    }

    private static void calculateScore(boolean isContains, boolean isSamePosition) {
        if (isContains && isSamePosition) {
            score.addStrike();
        }
        if (isContains && !isSamePosition) {
            score.addBall();
        }
    }


}

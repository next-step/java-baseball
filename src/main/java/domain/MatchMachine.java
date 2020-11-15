package domain;

import java.util.List;

public class MatchMachine {
    private static final int NUMBER_LENGTH = 3;
    private final List<Integer> computerNumbers;

    public MatchMachine(final List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public Score compare(List<Integer> baseballNumbers) {
        Score score = new Score();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            boolean isStrike = checkStrike(i, baseballNumbers.get(i), score);
            checkBall(isStrike, baseballNumbers.get(i), score);
        }
        return score;
    }

    private boolean checkStrike(int index, int baseballNumber, Score score) {
        if (computerNumbers.get(index) == baseballNumber) {
            score.addStrike();
            return true;
        }
        return false;
    }

    private void checkBall(boolean isStrike, int baseballNumber, Score score) {
        if (!isStrike && computerNumbers.contains(baseballNumber)) {
            score.addBall();
        }
    }
}

package domain;

public class MatchMachine {
    private static final int NUMBER_LENGTH = 3;
    private final String computerNumber;

    public MatchMachine(final String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public Score compare(final String baseballNumber) {
        Score score = new Score();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            boolean isStrike = checkStrike(i, baseballNumber.charAt(i), score);
            checkBall(isStrike, baseballNumber.charAt(i), score);
        }
        return score;
    }

    private boolean checkStrike(int index, char charBN, Score score) {
        if (computerNumber.charAt(index) == charBN) {
            score.addStrike();
            return true;
        }
        return false;
    }

    private void checkBall(boolean isStrike, char charBN, Score score) {
        if (!isStrike && computerNumber.contains(String.valueOf(charBN))) {
            score.addBall();
        }
    }
}

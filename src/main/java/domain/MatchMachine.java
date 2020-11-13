package domain;

public class MatchMachine {
    private static final int NUMBER_LENGTH = 3;
    private String computerNumber;

    public MatchMachine(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public Score compare(String baseballNumber) {
        Score score = new Score();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.charAt(i) == baseballNumber.charAt(i)) {
                score.addStrike();
                continue;
            }
            if (computerNumber.contains(String.valueOf(baseballNumber.charAt(i)))) {
                score.addBall();
            }
        }
        return score;
    }
}

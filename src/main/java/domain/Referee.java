package domain;

public class Referee {
    private final BaseballNumbers answerNumbers;

    public Referee(BaseballNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public int getStrikeCount(BaseballNumbers userNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            count += answerNumbers.isStrike(userNumbers.get(i), i);
        }
        return count;
    }

    public int getBallCount(BaseballNumbers userNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            count += answerNumbers.isBall(userNumbers.get(i), i);
        }
        return count;
    }
}

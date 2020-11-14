package domain;

public class Referee {
    private final AnswerNumbers answerNumbers;

    public Referee(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public int getStrikeCount(UserNumbers userNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            count += answerNumbers.isStrike(userNumbers.get(i), i);
        }
        return count;
    }

    public int getBallCount(UserNumbers userNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            count += answerNumbers.isBall(userNumbers.get(i), i);
        }
        return count;
    }
}

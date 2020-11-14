package domain;

public class Referee {
    private AnswerNumber answerNumber;

    public Referee(AnswerNumber answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getStrikeCount(UserNumber userNumber) {
        String answerNumberString = String.valueOf(answerNumber.getNumber());
        String userNumberString = String.valueOf(userNumber.getNumber());
        int countOfStrike = 0;
        for (int i = 0; i < 3; i++) {
            char answerNumberChar = answerNumberString.charAt(i);
            char userNumberChar = userNumberString.charAt(i);
            countOfStrike += plusIfSameChar(answerNumberChar, userNumberChar);
        }
        return countOfStrike;
    }

    private int plusIfSameChar(char answerNumberChar, char userNumberChar) {
        if (answerNumberChar == userNumberChar) {
            return 1;
        }
        return 0;
    }

    public int getBallCount(UserNumber userNumber) {
        String answerNumberString = String.valueOf(answerNumber.getNumber());
        String userNumberString = String.valueOf(userNumber.getNumber());
        int countOfBall = 0;
        for (int i = 0; i < 3; i++) {
            char userNumberChar = userNumberString.charAt(i);
            countOfBall += plusIfExistAndNotSameIndex(answerNumberString, userNumberChar, i);
        }
        return countOfBall;
    }

    private int plusIfExistAndNotSameIndex(String answerNumberString, char userNumberChar, int position) {
        int index = answerNumberString.indexOf(userNumberChar);
        if (index != -1 && index != position) {
            return 1;
        }
        return 0;
    }
}

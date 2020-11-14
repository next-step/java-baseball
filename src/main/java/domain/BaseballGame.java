package domain;

public class BaseballGame {
    private final Referee referee;

    public BaseballGame(Referee referee) {
        this.referee = referee;
    }

    public static BaseballGame startGame() {
        AnswerNumber answerNumber = AnswerNumber.init();
        Referee referee = new Referee(answerNumber);
        return new BaseballGame(referee);
    }

    public Result getResult(UserNumber userNumber) {
        int countOfStrike = referee.getCountOfStrike(userNumber);
        int countOfBall = referee.getCountOfBall(userNumber);
        if (countOfBall == 0 && countOfStrike == 0) {
            return SpecialResultType.NOTHING;
        }
        if (countOfStrike == 3) {
            return SpecialResultType.THREE_STRIKE;
        }
        return new Hint(countOfStrike, countOfBall);
    }
}

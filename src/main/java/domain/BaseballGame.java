package domain;

public class BaseballGame {
    private final Referee referee;

    public BaseballGame(Referee referee) {
        this.referee = referee;
    }

    public static BaseballGame startGame() {
        AnswerNumbers answerNumbers = AnswerNumbers.init();
        Referee referee = new Referee(answerNumbers);
        return new BaseballGame(referee);
    }

    public Result getResult(UserNumbers userNumbers) {
        int countOfStrike = referee.getStrikeCount(userNumbers);
        int countOfBall = referee.getBallCount(userNumbers);
        if (countOfBall == 0 && countOfStrike == 0) {
            return SpecialResultType.NOTHING;
        }
        if (countOfStrike == 3) {
            return SpecialResultType.THREE_STRIKE;
        }
        return new Hint(countOfStrike, countOfBall);
    }
}

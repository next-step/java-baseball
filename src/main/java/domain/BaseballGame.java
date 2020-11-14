package domain;

public class BaseballGame {
    private final GameNumber answer;

    public BaseballGame(GameNumber answer) {
        this.answer = answer;
    }

    public static BaseballGame startGame() {
        GameNumber answerNumber = GameNumber.generateRandomGameNumber();
        return new BaseballGame(answerNumber);
    }

    public GuessResult getGuessResult(GameNumber userNumber) {
        GuessResult guessResult = GuessResult.init();
        for (int i = 0; i < answer.size(); i++) {
            MatchType matchType = answer.judgeMatchType(userNumber.get(i), i);
            guessResult.increase(matchType);
        }
        return guessResult;
    }
}

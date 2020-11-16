package domain;

import java.util.Objects;

public class BaseballGame {
    private final GameNumber answer;

    public BaseballGame(GameNumber answer) {
        this.answer = answer;
    }

    public static BaseballGame startNewGame() {
        GameNumber answerNumber = GameNumber.generateRandomGameNumber();
//        System.out.println(answerNumber);
        return new BaseballGame(answerNumber);
    }

    public GuessResult getGuessResult(GameNumber userNumber) {
        GuessResult guessResult = GuessResult.init();
        for (int i = 0; i < answer.size(); i++) {
            MatchType matchType = answer.judgeMatchType(userNumber.get(i), i);
            guessResult.increaseMatchCount(matchType);
        }
        return guessResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballGame that = (BaseballGame) o;
        return answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }
}

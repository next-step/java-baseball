package domain;

import java.util.Set;

public class MatchMachine {
    private final Set<BaseballNumber> computerNumbers;

    public MatchMachine(final Set<BaseballNumber> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public ResultGame compare(final BaseballNumbers baseballNumbers) {
        ResultGame resultGame = new ResultGame();
        for (BaseballNumber computerNumber : computerNumbers) {
            resultGame.add(baseballNumbers.compareNumbers(computerNumber));
        }
        return resultGame;
    }
}

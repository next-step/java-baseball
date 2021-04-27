package baseball.domain;

public class BaseballGame {
    private final Numbers randomNumbers;
    private final Numbers userNumbers;

    public BaseballGame(Numbers randomNumbers, Numbers userNumbers) {
        this.randomNumbers = randomNumbers;
        this.userNumbers = userNumbers;
    }

    public boolean isNotEnd() {
        return !randomNumbers.equals(userNumbers);
    }

    public BaseballResult playOneRound() {
        return BaseballResult.getResult(randomNumbers, userNumbers);
    }

}

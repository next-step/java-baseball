package baseball.domain;

import java.util.Objects;

public class GameChecker {
    public GameResult check(BaseballNumberGroup playerNumbers, BaseballNumberGroup computerNumbers) {
        int numberOfStrikes = checkStrikes(playerNumbers, computerNumbers);
        int numberOfBalls = checkBalls(playerNumbers, computerNumbers);
        return GameResult.of(playerNumbers, computerNumbers, numberOfStrikes, numberOfBalls);
    }

    private int checkStrikes(BaseballNumberGroup playerNumbers, BaseballNumberGroup computerNumbers) {
        int numberOfStrikes = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            numberOfStrikes += checkStrike(playerNumbers.get(i), computerNumbers.get(i));
        }
        return numberOfStrikes;
    }

    private int checkStrike(Integer playerNumber, Integer computerNumber) {
        return Objects.equals(playerNumber, computerNumber) ? 1 : 0;
    }

    private int checkBalls(BaseballNumberGroup playerNumbers, BaseballNumberGroup computerNumbers) {
        int numberOfBalls = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            numberOfBalls += checkBall(playerNumbers.get(i), i, computerNumbers);
        }
        return numberOfBalls;
    }

    private int checkBall(Integer playerNumber, int playerNumberDigit, BaseballNumberGroup computerNumbers) {
        return computerNumbers.contains(playerNumber) && (computerNumbers.indexOf(playerNumber) != playerNumberDigit) ? 1 : 0;
    }
}

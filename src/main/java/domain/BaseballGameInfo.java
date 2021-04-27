package domain;

import java.util.List;

public class BaseballGameInfo {
    private static final int BASEBALL_SIZE = 3;

    private final List<Integer> userBaseballNumbers;
    private final List<Integer> targetBaseballNumbers;
    private int strikeCount;
    private int ballCount;
    private boolean isWinning;

    public BaseballGameInfo(List<Integer> userBaseballNumbers, List<Integer> targetBaseballNumbers) {
        this.userBaseballNumbers = userBaseballNumbers;
        this.targetBaseballNumbers = targetBaseballNumbers;
        setGameState();
    }

    private void setGameState() {
        initializeGame();
        match();
        isWinning();
    }

    private void initializeGame() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.isWinning = false;
    }

    private void match() {
        for(int i = 0; i < BASEBALL_SIZE; i++) {
            ballCount += checkBall(userBaseballNumbers, i);
            strikeCount += checkStrike(userBaseballNumbers, i);
        }
    }

    private int checkBall (List<Integer> userBaseballNumbers, int idx) {
        if(targetBaseballNumbers.contains(userBaseballNumbers.get(idx)) &&
                !targetBaseballNumbers.get(idx).equals(userBaseballNumbers.get(idx))) {
            return 1;
        }
        return 0;
    }

    private int checkStrike (List<Integer> userBaseballNumbers, int idx) {
        if(targetBaseballNumbers.get(idx).equals(userBaseballNumbers.get(idx))){
            return 1;
        }
        return 0;
    }

    private void isWinning() {
        if(strikeCount == BASEBALL_SIZE) {
            this.isWinning = true;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean getIsWinning() {
        return isWinning;
    }
}
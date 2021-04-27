package baseball.service;

import baseball.enums.GameStatus;
import baseball.enums.MatchType;

import java.util.List;

public class ResultChecker {
    public static GameStatus gameStatus = GameStatus.PLAY;

    private final int ALL_STRIKE = 3;

    private List<Integer> userNumbers;
    private List<Integer> goalNumbers;

    private int strikeCount;
    private int ballCount;

    public ResultChecker() {
        this.goalNumbers = NumberGenerator.generateNumber();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void calculateMatchType() {
        int sizeOfGoalNumbers = goalNumbers.size();
        for (int index=0; index<sizeOfGoalNumbers; index++) {
            countMatchTypes(index);
        }
    }

    private void countMatchTypes(int index) {
        MatchType matchType = getMatchType(index);
        if (matchType == MatchType.STRIKE) {
            this.strikeCount++;
        }
        if (matchType == MatchType.BALL) {
            this.ballCount++;
        }
    }

    private MatchType getMatchType(int index) {
        if (userNumbers.get(index) == goalNumbers.get(index)) return MatchType.STRIKE;
        if (goalNumbers.contains(userNumbers.get(index))) return MatchType.BALL;

        return MatchType.NOTHING;
    }

    public void showMatchCount(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
        this.calculateMatchType();

        System.out.print(this.strikeCount + "스트라이크 ");
        System.out.println(this.ballCount + "볼");
    }

    public void checkAllMatches() {
        if (this.strikeCount == ALL_STRIKE) {
            gameStatus = GameStatus.END;
            gameStatus.printMessage();

            String flag = InputSupplier.getInput();
            this.gamePlayOrStopWithFlag(flag);
            return;
        }

        this.resetGameCount();
    }

    private void gamePlayOrStopWithFlag(String flag) {
        if (GameStatus.PLAY.getCode().equals(flag)) {
            List<Integer> generateNumbers = NumberGenerator.generateNumber();

            this.resetGameCount();
            this.setGoalNumbers(generateNumbers);

            gameStatus = GameStatus.PLAY;
        } else if (GameStatus.EXIT.getCode().equals(flag)){
            gameStatus = GameStatus.EXIT;
        }
    }

    public void resetGameCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public void setGoalNumbers(List<Integer> goalNumbers) {
        this.goalNumbers = goalNumbers;
    }

    public List<Integer> getGoalNumbers() {
        return goalNumbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}

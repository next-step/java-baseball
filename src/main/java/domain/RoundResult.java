package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final int LENGTH_OF_NUMBER = 3;
    private final List<String> result;
    private final List<BaseballNumber> computer;
    private final List<BaseballNumber> userNumber;
    int numberOfStrike = 0;
    int numberOfBall = 0;

    public RoundResult(List<BaseballNumber> userNumber, List<BaseballNumber> computer) {
        result = new ArrayList<>();
        this.userNumber = userNumber;
        this.computer = computer;
    }

    public List<String> getResult() {
        for (int userNumberIndex = 0; userNumberIndex < LENGTH_OF_NUMBER; userNumberIndex++) {
            getResultEachNumber(userNumberIndex);
        }
        if (numberOfBall > 0) {
            result.add(numberOfBall + BALL);
        }
        if (numberOfStrike > 0) {
            result.add(numberOfStrike + STRIKE);
        }
        if (result.size() == 0) {
            result.add(NOTHING);
        }
        return result;
    }

    private void getResultEachNumber(int userNumberIndex) {
        if (userNumber.get(userNumberIndex).getNumber() == computer.get(userNumberIndex).getNumber()) {
            numberOfStrike++;
            return;
        }
        for (int computerIndex = 0; computerIndex < LENGTH_OF_NUMBER; computerIndex++) {
            if (checkBall(userNumberIndex, computerIndex)) break;
        }
    }

    private boolean checkBall(int userNumberIndex, int computerIndex) {
        if (userNumber.get(userNumberIndex).getNumber() == computer.get(computerIndex).getNumber() && userNumberIndex != computerIndex) {
            numberOfBall++;
            return true;
        }
        return false;
    }
}

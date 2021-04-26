import java.util.List;

public class Baseball {

    private final int STRIKE_MAX_COUNT = 3;
    private int strike;
    private int ball;
    private List<Integer> opponentNumber;
    private List<Integer> userNumber;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public List<Integer> getOpponentNumber() {
        return opponentNumber;
    }

    public void setOpponentNumber(List<Integer> opponentNumber) {
        this.opponentNumber = opponentNumber;
    }

    public void setUserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public void compare() {
        for (int opponentIndex = 0; opponentIndex < opponentNumber.size(); opponentIndex++) {
            compareUser(opponentIndex);
        }
    }

    private void compareUser(int opponentIndex) {
        for (int userIndex = 0; userIndex < userNumber.size(); userIndex++) {
            match(opponentIndex, userIndex);
        }
    }

    private void match(int opponentIndex, int userIndex) {
        if (opponentIndex == userIndex && opponentNumber.get(opponentIndex) == userNumber.get(userIndex)) {
            strike();
            return;
        }
        if (opponentNumber.get(opponentIndex) == userNumber.get(userIndex)) {
            ball();
            return;
        }
    }

    private void strike() {
        strike++;
    }

    private void ball() {
        ball++;
    }

    public void init() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean isStrike() {
        return STRIKE_MAX_COUNT == strike;
    }

    @Override
    public String toString() {
        if (strike != 0 && ball != 0) {
            return strike + " 스트라이크 " + ball + " 볼";
        }
        if (strike != 0 && ball == 0) {
            return strike + " 스트라이크";
        }
        if (strike == 0 && ball != 0) {
            return ball + " 볼";
        }
        return "낫싱";
    }

}
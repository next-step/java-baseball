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

    public void init() {
        this.strike = 0;
        this.ball = 0;
    }

}
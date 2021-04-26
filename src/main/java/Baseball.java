import java.util.List;

public class Baseball {

    private final int STRIKE_MAX_COUNT = 3;
    private int strike;
    private int ball;
    private List<Integer> opponentNumber;
    private List<Integer> userNumber;

    public List<Integer> getOpponentNumber() {
        return opponentNumber;
    }

    public void setOpponentNumber(List<Integer> opponentNumber) {
        this.opponentNumber = opponentNumber;
    }

}

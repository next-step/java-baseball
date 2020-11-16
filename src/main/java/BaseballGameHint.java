import java.util.ArrayList;

public class BaseballGameHint {

    private Strike strike;
    private Ball ball;
    private Nothing nothing;

    public final int NUMBER_SIZE = 3;

    private final ArrayList<Integer> correctNumbers;
    private final ArrayList<Integer> inputNumbers;

    private final ArrayList<Integer> strikeIndexArray = new ArrayList<>();

    BaseballGameHint(ArrayList<Integer> correctNumbers, ArrayList<Integer> inputNumbers) {
        this.correctNumbers = correctNumbers;
        this.inputNumbers = inputNumbers;
    }

    public Strike getStrike() {
        return strike;
    }

    public void setStrike(Strike strike) {
        this.strike = strike;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Nothing getNothing() {
        return nothing;
    }

    public void setNothing(Nothing nothing) {
        this.nothing = nothing;
    }

    public void setStrike(int index, Strike strike) {
        int correct = correctNumbers.get(index);
        int input = inputNumbers.get(index);
        if (correct == input) {
            strike.add();
            strikeIndexArray.add(index);
        }
        this.strike = strike;
    }

    public void setBall(int index, Ball ball) {
        if (strikeIndexArray.contains(index)) {
            this.ball = ball;
            return;
        }
        int input = inputNumbers.get(index);
        if (correctNumbers.contains(input)) {
            ball.add();
        }
        this.ball = ball;
    }

    public void create(Strike strike, Ball ball, Nothing nothing) {
        for (int index = 0; index < NUMBER_SIZE; index++) {
            setStrike(index, strike);
        }
        for (int index = 0; index < NUMBER_SIZE; index++) {
            setBall(index, ball);
        }
        if (strike.getCount() == 0 && ball.getCount() == 0) {
            nothing.add();
        }
        setNothing(nothing);
    }
}

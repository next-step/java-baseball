import java.util.ArrayList;

public class BaseballHintMaker {

    public final int NUMBER_SIZE = 3;

    private ArrayList<Integer> correctNumbers;
    private ArrayList<Integer> inputNumbers;

    private ArrayList<Integer> strikeIndexArray = new ArrayList(NUMBER_SIZE);
    private ArrayList<Integer> ballIndexArray = new ArrayList(NUMBER_SIZE);

    BaseballHintMaker(ArrayList<Integer> correctNumbers, ArrayList<Integer> inputNumbers) {
        this.correctNumbers = correctNumbers;
        this.inputNumbers = inputNumbers;
    }

    public Strike getStrikeHint(int index, Strike strike) {
        int correct = correctNumbers.get(index);
        int input = inputNumbers.get(index);
        if (correct == input) {
            strike.add();
            strikeIndexArray.add(index);
        }
        return strike;
    }

    private void addBallCount(int index, Ball ball) {
        int input = inputNumbers.get(index);
        if (correctNumbers.contains(input)) {
            ball.add();
            ballIndexArray.add(index);
        }
    }

    public Ball getBallHint(int index, Ball ball) {
        if (!strikeIndexArray.contains(index)) {
            addBallCount(index, ball);
        }
        return ball;
    }

}

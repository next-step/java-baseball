import java.util.ArrayList;

public class BaseballHintMaker {

    public final int NUMBER_SIZE = 3;

    private final ArrayList<Integer> correctNumbers;
    private final ArrayList<Integer> inputNumbers;

    private final ArrayList<Integer> strikeIndexArray = new ArrayList<>();

    BaseballHintMaker(ArrayList<Integer> correctNumbers, ArrayList<Integer> inputNumbers) {
        this.correctNumbers = correctNumbers;
        this.inputNumbers = inputNumbers;
    }

    public void getStrikeHint(int index, Strike strike) {
        int correct = correctNumbers.get(index);
        int input = inputNumbers.get(index);
        if (correct == input) {
            strike.add();
            strikeIndexArray.add(index);
        }
    }

    public void getBallHint(int index, Ball ball) {
        if (strikeIndexArray.contains(index)) {
            return;
        }
        int input = inputNumbers.get(index);
        if (correctNumbers.contains(input)) {
            ball.add();
        }
    }

}

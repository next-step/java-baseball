import java.util.ArrayList;

public class BaseballHintMaker {

    public final int NUMBER_SIZE = 3;

    private ArrayList<Integer> correctNumbers;
    private ArrayList<Integer> inputNumbers;

    private ArrayList<Integer> strikeIndexArray = new ArrayList(NUMBER_SIZE);

    BaseballHintMaker(ArrayList<Integer> correctNumbers, ArrayList<Integer> inputNumbers) {
        this.correctNumbers = correctNumbers;
        this.inputNumbers = inputNumbers;
    }

    private void addStrikeCount(int index, Strike strike) {
        int correct = correctNumbers.get(index);
        int input = inputNumbers.get(index);
        if (correct == input) {
            strike.add();
            strikeIndexArray.add(index);
        }
    }

    public Strike getStrikeHint() {
        Strike strike = new Strike();
        for (int index = 0; index < NUMBER_SIZE; index++) {
            addStrikeCount(index, strike);
        }
        return strike;
    }

}

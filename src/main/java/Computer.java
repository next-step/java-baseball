import java.util.ArrayList;
import java.util.Random;

public class Computer {
    static final int NUMBER_OF_DIGIT = 3;
    static final int MAX_NUMBER = 9;
    static final int MIN_NUMBER = 1;

    private ArrayList<Integer> hiddenNumbers = new ArrayList<Integer>();

    public ArrayList<Integer> getHiddenNumbers() {
        return hiddenNumbers;
    }

    public void setHiddenNumbers(ArrayList<Integer> hiddenNumbers) {
        this.hiddenNumbers = hiddenNumbers;
    }

    public void selectRandomNumber() {
        Random random = new Random();
        random.setSeed(System.nanoTime());

        hiddenNumbers.clear();
        while (hiddenNumbers.size() != NUMBER_OF_DIGIT) {
            int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            insertNumber(randomNumber);
        }
    }

    private void insertNumber(int randomNumber) {
        if (!hiddenNumbers.contains(randomNumber)) {
            hiddenNumbers.add(randomNumber);
        }
    }

}

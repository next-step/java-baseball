import java.util.ArrayList;
import java.util.Random;

public class BaseballNumberMaker {

    public final int MIN_VALUE = 1;
    public final int MAX_VALUE = 9;
    public final int NUMBER_SIZE = 3;

    public Integer makeRandomNumber() {
        Random random = new Random();
        return random.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
    }

    public void addNonDuplicateNumber(ArrayList<Integer> numbers, int random) {
        if (!numbers.contains(random)) {
            numbers.add(random);
        }
    }

    public ArrayList<Integer> makeNonDuplicateRandomNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_SIZE) {
            int random = makeRandomNumber();
            addNonDuplicateNumber(numbers, random);
        }
        return numbers;
    }

}

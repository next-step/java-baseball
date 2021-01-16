import java.util.HashMap;
import java.util.Random;

public class BaseballComputer {
    private static final Random RANDOM = new Random();
    private HashMap<Integer, Integer> numbers;

    public BaseballComputer() {
        numbers = new HashMap<>();
        setRandomNumbers();
    }

    private void setRandomNumbers() {
        for (int i = 0; i < 3; ++i) {
            numbers.put(getOneRandomNumber(), i);
        }
    }

    private int getOneRandomNumber() {
        int randomNumber;
        while (true) {
            randomNumber = RANDOM.nextInt(9) + 1;
            if (!isDuplicatedInNumbers(randomNumber)) {
                break;
            }
        }
        return randomNumber;
    }

    private boolean isDuplicatedInNumbers(int number) {
        if (numbers.containsKey(number)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public HashMap<Integer, Integer> getNumbers() {
        return numbers;
    }
}

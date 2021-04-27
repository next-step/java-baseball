import java.util.*;

public class Computer {

    public static final int NUMBERS_LENGTH = 3;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;

    private Set<Integer> numbers;
    private final Random random = new Random();

    public void initializeNewNumbers() {
        numbers = new HashSet<>();

        while (numbers.size() < NUMBERS_LENGTH) {
            numbers.add(generateRandomNaturalNumber());
        }
    }

    private int generateRandomNaturalNumber() {
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
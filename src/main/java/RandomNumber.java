import java.util.*;

public class RandomNumber {

    private static final int MAX_AVAILABLE_LENGTH = 10;

    private List<String> numbers;

    private RandomNumber(int length) {
        numbers = new ArrayList<>();
        while (numbers.size() != length) {
            numbers.add(RandomNumberGenerator.getWithExceptNumbers(numbers));
        }
    }

    public static RandomNumber generate(int length) {
        if (length > MAX_AVAILABLE_LENGTH) {
            length = MAX_AVAILABLE_LENGTH;
        }
        return new RandomNumber(length);
    }

    public boolean contain(String number) {
        return numbers.contains(number);
    }

    public String get(int index) {
        return numbers.get(index);
    }

    private static class RandomNumberGenerator {

        private static String getWithExceptNumbers(List<String> exceptNumbers) {
            String result = generateOneRandomNumber();
            while (exceptNumbers.contains(result)) {
                result = generateOneRandomNumber();
            }
            return result;
        }

        private static String generateOneRandomNumber() {
            return String.valueOf((int) (Math.random() * 10));
        }

    }

}

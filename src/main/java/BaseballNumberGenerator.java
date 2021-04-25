import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 베이스볼 숫자 생성기
 */
public class BaseballNumberGenerator {
    private static Random random = new Random();
    private static int BASEBALL_NUMBER_SIZE = 3;
    public static String generate() {
        List<String> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_NUMBER_SIZE) {
            putBaseballNumber(numbers, generateRandomNumber());
        }
        return String.join("", numbers);
    }

    private static void putBaseballNumber(List<String> numbers, String generateRandomNumber) {
        if (validateBaseballNumbers(numbers, generateRandomNumber)) {
            numbers.add(generateRandomNumber);
        }
    }

    private static String generateRandomNumber() {
        return String.valueOf(random.nextInt(9) + 1);
    }

    private static Boolean validateBaseballNumbers(List<String> numbers, String generateRandomNumber) {
        if (numbers.contains(generateRandomNumber)) {
            return false;
        }
        return true;
    }
}

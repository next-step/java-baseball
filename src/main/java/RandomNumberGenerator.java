import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static Number generate() {
        return new Number(getNumber());
    }

    private static int getNumber() {
        int number = 0;
        for (int i = 1; i <= 100; i *= 10) {
            int digit = random.nextInt(9) + 1;
            number += digit * i;
        }
        return number;
    }
}

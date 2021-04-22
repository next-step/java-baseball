import java.util.Random;

public class NumberGenerator {

    private static Random random = new Random();

    public static String generateNumber(int howManyDigit) {
        String number = "";
        for (int i = 0; i < howManyDigit; i++) {
            String digit = String.valueOf((generateDigit()));
            number = number.concat(digit);
        }
        return number;
    }

    public static int generateDigit() {
        return random.nextInt(9) + 1;
    }
}

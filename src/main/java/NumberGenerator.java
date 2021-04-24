import java.util.Random;

public class NumberGenerator {

    private static Random random = new Random();

    public static String generateNumber() {
        String number = "";

        while (number.length() < GameOptions.HOW_MANY_DIGIT) {
            String singleDigit = generateDigit();
            number = concatDigit(number, singleDigit);
        }

        return number;
    }

    private static String concatDigit(String number, String singleDigit) {
        if (!number.contains(singleDigit)) {
            number = number.concat(singleDigit);
        }

        return number;
    }

    public static String generateDigit() {
        int i = random.nextInt(9) + 1;

        return String.valueOf(i);
    }
}

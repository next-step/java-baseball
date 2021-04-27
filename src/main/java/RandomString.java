import java.util.ArrayList;
import java.util.Random;

public class RandomString {
    public static String generate(int maxLength) {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < maxLength) {
            int num = getRandNum();
            duplicated(numbers, num);
        }

        return numbersToString(numbers);
    }

    private static int getRandNum() {
        Random rand = new Random();
        return rand.nextInt(9) + 1;
    }

    private static String numbersToString(ArrayList<Integer> numbers) {
        String result = "";
        for (Integer number : numbers) {
            result = result.concat(number.toString());
        }
        return result;
    }

    private static void duplicated(ArrayList<Integer> numbers, int num) {
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }
}

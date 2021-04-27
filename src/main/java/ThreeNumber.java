import java.util.ArrayList;
import java.util.Random;

public class ThreeNumber {
    
    public static String get() {
        ArrayList<String> result = new ArrayList<>();
        String number = getRandomNumber();
        while (result.size() < 3) {
            addNumber(result, number);
            number = getRandomNumber();
        }
        return changeListToString(result);
    }

    public static String changeListToString(ArrayList<String> input) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (result.length() < input.size()) {
            result.append(input.get(i++));
        }
        return result.toString();
    }

    public static String getRandomNumber() {
        Random rand = new Random();
        int upperbound = 9;//generate random values from 0-8
        int int_random = rand.nextInt(upperbound);
        int_random++;//make random value 1-9
        return Integer.toString(int_random);
    }

    public static ArrayList<String> addNumber(ArrayList<String> array, String number) {
        if (array.contains(number)) {//check duplicated number
            return array;
        }
        array.add(number);
        return array;
    }
}

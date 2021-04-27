package baseball.utils;

import java.util.LinkedList;

public class NumberUtils {

    public static LinkedList<Integer> splitToList(int number) {
        LinkedList<Integer> bucket = new LinkedList<Integer>();
        while (number > 0) {
            bucket.push( number % 10 );
            number = number / 10;
        }

        return bucket;
    }

    public static int[] splitToArray(int number) {
        LinkedList<Integer> bucket = splitToList(number);
        int[] result = new int[bucket.size()];
        int index = 0;
        while (!bucket.isEmpty()) {
            result[index] = bucket.pop();
            index++;
        }

        return result;
    }
}

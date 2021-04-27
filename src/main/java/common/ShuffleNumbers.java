package common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleNumbers {

    public static String getSuffledThreeNumbers(String[] numbers, int maxLength) {
        List<String> list = Arrays.asList(numbers);
        Collections.shuffle(list);
        return String.join("", list.subList(0,maxLength));
    }
}

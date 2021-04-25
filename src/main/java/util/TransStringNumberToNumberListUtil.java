package util;

import java.util.ArrayList;
import java.util.List;

public class TransStringNumberToNumberListUtil {

    private TransStringNumberToNumberListUtil(){
    }

    public static List<Integer> toNumberList(String numberString) {
        List<Integer> numbers = new ArrayList<>();
        char[] numberChar = numberString.toCharArray();
        for (char number : numberChar) {
            numbers.add(Integer.parseInt(String.valueOf(number)));
        }

        return numbers;
    }
}

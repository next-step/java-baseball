package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberUtil {
    /**
     * Integer 타입의 숫자의 각 자릿수를 분리하여 List 형태로 반환
     * @param number 숫자
     * @return Integer 타입의 List Collection
     */
    public static List<Integer> numberToListFrom(int number) {
        List<Integer> numberList = new ArrayList<>();
        int copyNumber = number;
        for (int i = String.valueOf(number).length() - 1; i >= 0; i--) {
            int index = (int) Math.pow(10, i);
            numberList.add(copyNumber / index);
            copyNumber %= index;
        }
        return numberList;
    }
}

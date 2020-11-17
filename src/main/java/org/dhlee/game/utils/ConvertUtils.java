package org.dhlee.game.utils;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtils {
    public static List<Integer> StringToIntList(String value, int length) {
        int index = 0;
        List<Integer> array = new ArrayList<Integer>(length);

        while(index < length) {
            Integer number = Integer.parseInt(String.valueOf(value.charAt(index++)));
            array.add(number);
        }

        return array;
    }
}

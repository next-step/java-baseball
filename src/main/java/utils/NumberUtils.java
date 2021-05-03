package utils;

import domain.Number;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumberUtils {
    public static List<Number> toList(Collection<Integer> collection){
        List<Number> list = new ArrayList<>();
        int index = 0;
        for (Integer number : collection) {
            list.add(Number.of(number, index++));
        }
        return list;
    }

    public static List<Number> toList(String inputNumbers) {
        List<Number> list = new ArrayList<>();
        int index = 0;
        for (String number : inputNumbers.split("")) {
            list.add(Number.of(number, index++));
        }
        return list;
    }
}

package baseball.util;

import java.util.Arrays;
import java.util.List;

public class ListConverter {
    public static List<Integer> convert(String value) throws IllegalArgumentException {
        Integer[] values = new Integer[value.length()];
        for(int i = 0; i < value.length(); i++){
            values[i] = Character.getNumericValue(value.charAt(i));
            ifNotNumberThrowIllegalArgumentException(values[i]);
        }
        return Arrays.asList(values);
    }

    private static void ifNotNumberThrowIllegalArgumentException(int value) throws IllegalArgumentException {
        if(value > 9 || value < 0){
            throw new IllegalArgumentException();
        }
    }
}

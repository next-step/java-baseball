package baseball.util;

import java.util.Collection;

public class StringUtils {


    public static String join(Collection<Integer> integers, String delimiter) {
        StringBuilder result = new StringBuilder();

        for (Integer integer : integers) {
            result.append(integer).append(delimiter);
        }

        return result.toString();
    }
}

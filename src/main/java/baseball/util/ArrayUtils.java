package baseball.util;

import java.util.Objects;

public class ArrayUtils {
    public static boolean isEmpty(char[] arr) {
        return Objects.isNull(arr) || arr.length == 0;
    }
}

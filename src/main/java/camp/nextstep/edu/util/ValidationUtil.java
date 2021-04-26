package camp.nextstep.edu.util;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {

    private ValidationUtil() {

    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDistinct(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        return str.length() == set.size();
    }

    public static boolean isNotContains(String str, CharSequence s) {
        return !str.contains(s);
    }
}

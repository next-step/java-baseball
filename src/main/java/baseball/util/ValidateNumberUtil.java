package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ValidateNumberUtil {
    private ValidateNumberUtil() {}

    public static final int NUMBER_LENGTH = 3;

    public static boolean validateNumber(String selectNumber) {
        return selectNumber.length() == NUMBER_LENGTH && duplicateCheckNumberLength(selectNumber) == NUMBER_LENGTH;
    }

    public static int duplicateCheckNumberLength(String selectNumber) {
        Set<Character> lengthCheckSet = new HashSet<>();

        for (int i = 0; i < selectNumber.length(); i++) {
            lengthCheckSet.add(selectNumber.charAt(i));
        }

        return lengthCheckSet.size();
    }
}

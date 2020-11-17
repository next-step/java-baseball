package baseball;

import java.util.HashSet;
import java.util.Set;

/**
 * 입력 숫자 유효성 체크 클래스
 */
public class BaseballInputValidator {

    /**
     * 입력값 유효성 체크
     * @param input 입력 문자열
     * @return 유효하면 true, 아니면 false
     */
    public static boolean validate(String input) {
        String regExp = "^[1-9]+$";
        int length = input.length();
        if (!input.matches(regExp) || length <= 0 || length > 3) {
            return false;
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < length; i++) {
            uniqueChars.add(input.charAt(i));
        }
        return uniqueChars.size() >= 3;
    }

}

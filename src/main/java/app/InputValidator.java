package app;

/**
 * 입력값 validation
 */
public class InputValidator {

    public static final int MAX_LENGTH = 3;

    /**
     * 입력한 숫자가 3자리인지 길이 체크와 정규식으로 숫자인지 체크
     * @param input 사용자 입력값
     * @return
     */
    public static boolean isValid(String input) {
        boolean result = true;
        String regExp = "^[0-9]+$";

        if (input.length() > MAX_LENGTH || !input.matches(regExp)) {
            result = false;
        }

        return result;
    }
}

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public String validateInputValue(String inputValue, int digit) {
        String message = null;

        if (isEmpty(inputValue)) {
            message = "공백으로 입력할 수 없습니다.";
        }

        if (isInCorrectDigit(inputValue, digit)) {
            message = digit + "자리 숫자를 입력하세요.";
        }

        if (isExistZero(inputValue)) {
            message = "0을 포함한 숫자는 입력할 수 없습니다.";
        }

        if (isDuplicate(inputValue)) {
            message = "중복되지 않은 숫자로 입력해 주세요.";
        }

        return message;
    }

    /**
     * 입력값의 공백여부 체크
     * @param inputValue
     * @return
     */
    public boolean isEmpty(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 입력값의 자리수 체크
     * @param inputValue
     * @param digit
     * @return
     */
    public boolean isInCorrectDigit(String inputValue, int digit) {
        if (inputValue.length() != digit) {
            return true;
        }
        return false;
    }

    /**
     * 입력값의 숫자 0 존재 여부 판단
     * @param inputValue
     * @return
     */
    public boolean isExistZero(String inputValue) {
        if (inputValue.indexOf('0') > 0) {
            return true;
        }
        return false;
    }

    /**
     * 입력값의 중복값 존재 여부 판단
     * @param inputValue
     * @return
     */
    public boolean isDuplicate(String inputValue) {
        CharSequence inputStr = inputValue;
        int length = inputStr.length();
        Set<Character> uniqueChars = new HashSet<Character>();

        for (int i = 0; i < length; ++i) {
            uniqueChars.add(inputStr.charAt(i));
        }

        return uniqueChars.size() != length;
    }
}
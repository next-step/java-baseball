public class ValidationInputUtils {
    /**
     * 입력 값이 숫자인 지 확인
     * @param input 입력 값
     * @return boolean 숫자 값 확인
     */
    public static boolean validInputNumber(String input) {
        return input.matches("[+-]?\\d*(\\.\\d+)?");
    }

    /**
     * 중복 입력 값이 있는 지 확인
     * @param input 입력 값
     * @return boolean 중복 입력 확인
     */
    public static boolean validInputDuplication(String input) {
        return input.replaceAll("(.)(?=.*\\1)", "").length() >= input.length();
    }
}

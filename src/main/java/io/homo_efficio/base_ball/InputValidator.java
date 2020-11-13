package io.homo_efficio.base_ball;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-13
 */
public class InputValidator {

    public static void check3Digits(String nums) {
        checkLength(nums);
        checkAllDigit(nums);
    }

    private static void checkLength(String nums) {
        if (nums == null || nums.length() != 3) {
            throw new IllegalArgumentException("숫자는 세 자리여야 합니다.");
        }
    }

    private static void checkAllDigit(String nums) {
        char[] chars = nums.toCharArray();
        for (char ch : chars) {
            checkDigit(ch);
        }
    }

    public static void checkDigit(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException("입력된 값은 숫자여야 합니다.");
        }
    }
}

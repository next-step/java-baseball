package utils;

public class BaseballUtils {
    public static boolean isValidInput(String input) {
        if (input.length() != 3) {
            System.out.println("3자리로 입력해야합니다.");
            return false;
        }
        if (!isInOneToNine(input.charAt(0)) || !isInOneToNine(input.charAt(1)) || !isInOneToNine(input.charAt(2))) {
            System.out.println("1에서 9까지의 숫자만 입력해야합니다.");
            return false;
        }
        return true;
    }

    private static boolean isInOneToNine(char number) {
        return number >= '1' && number <= '9';
    }
}

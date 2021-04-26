package homework.baseball.util;

public class ValidationChecker {

    private static boolean isEachAllDifferentCharacter(String answerStr) {
        char[] charArray = answerStr.toCharArray();
        boolean result = charArray[0] != charArray[1] && charArray[0] != charArray[2] && charArray[1] != charArray[2];
        if (result) {
            return true;
        }
        System.out.println("숫자 중에 중복되는 값이 있습니다.");
        return false;
    }

    public static boolean isCorrectFormatForAnswer(String answerStr) {
        if (answerStr.length() == 3) {
            answerStr = answerStr.replaceAll("[^1-9]", "");
            if (answerStr.length() != 3) {
                System.out.println("1에서 9까지 숫자만 입력해주세요.");
                return false;
            }
            return isEachAllDifferentCharacter(answerStr);

        }
        System.out.println("1에서 9까지 숫자를 3자리로 입력해주세요.");
        return false;
    }

    public static boolean isCorrectFormatForRetry(String retryStr) {
        if (retryStr.length() == 1) {
            retryStr = retryStr.replaceAll("[^1-2]", "");
            if (retryStr.length() != 1) {
                System.out.println("1 혹은 2 숫자만 입력해주세요.");
                return false;
            }
            return true;
        }
        System.out.println("1 혹은 2 숫자를 1자리로 입력해주세요.");
        return false;
    }
}

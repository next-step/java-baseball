package util;

import static domain.BaseballGame.NUMBER_SIZE;

public class ValidationUtil {

    public static void validateUserInput(char[] userInput) {
        validateInputSize(userInput.length);
        validateInputType(userInput);
        validateInputDuplicate(userInput);
    }

    public static void validateUserReplayInput(String userInput) {
        validateReplayInputType(userInput);
    }

    private static void validateInputSize(int length) {
        if(length != NUMBER_SIZE) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 3자리수를 입력해야합니다. 다시 입력해주세요.");
        }
    }

    private static void validateInputType(char[] userInput) {
        for (char c : userInput) {
            int tmp = c - '0';
            if (tmp > 9 || tmp < 1) {
                throw new IllegalArgumentException("잘못 입력하셨습니다. 숫자가 아닙니다. 다시 입력해주세요.");
            }
        }
    }

    private static void validateInputDuplicate(char[] userInput) {
        boolean[] checkDuplication = new boolean[10];
        for (char c : userInput) {
            int tmp = c - '0';
            if (!checkDuplication[tmp]) {
                checkDuplication[tmp] = true;
            } else {
                throw new IllegalArgumentException("잘못 입력하셨습니다. 각 자리수 숫자는 달라야 합니다. 다시 입력해주세요.");
            }
        }
    }

    private static void validateReplayInputType(String userInput) {
        if(userInput.length() != 1) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 1 또는 2 를 입력해주세요.");
        }
        int tmp = userInput.charAt(0) - '0';
        if(tmp != 1 && tmp != 2) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 1 또는 2 를 입력해주세요.");
        }
    }

}

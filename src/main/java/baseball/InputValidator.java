package baseball;

public class InputValidator {
    public static void validateGuessInput(String input) {
        if (input.length() != 3) {
            throw new AbnormalInputException("입력 길이가 맞지 않습니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new AbnormalInputException("숫자를 잘못 입력하셨습니다.");
        }
    }

    public static void validatePendingInput(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new AbnormalInputException("선택을 잘못 하셨습니다.");
    }
}

package game.baseball.number.exceptions;

enum ExceptionCodes {

    INVALID_USER_INPUT_TYPING("1(게임 시작) 또는 2(종료) 가 입력되어야 합니다.");

    private final String errorMessage;

    ExceptionCodes(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    String getErrorMessage(String input) {
        return errorMessage + ", [input]: " + input;
    }

    String getErrorMessage() {
        return errorMessage;
    }
}
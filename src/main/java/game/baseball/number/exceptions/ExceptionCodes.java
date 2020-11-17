package game.baseball.number.exceptions;

public enum ExceptionCodes {

    INVALID_INPUT_OF_DIFFERENT_THREE_NUMBERS("서로 다른 3자리의 숫자가 입력되어야 합니다."),
    INVALID_INPUT_OF_GAME_RESTART_OR_EXIT("1(게임 시작) 또는 2(종료) 가 입력되어야 합니다."),
    SUPPRESS_INSTANCE("유틸리티 클래스 메소드는 static 메소드로 접근해야 합니다.");

    private final String errorMessage;

    ExceptionCodes(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString(Object input) {
        if (input == null) {
            input = "null";
        }
        return errorMessage + " [입력]: " + input.toString();
    }

    public String toString(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }
        return errorMessage + " [입력]: " + stringBuilder.toString();
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}

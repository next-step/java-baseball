public enum ExceptionMessage {

    NOT_ENOUGH_ELEMENTS("내용이 충분하지 않습니다."),
    NOT_A_NUMBER("숫자가 아닙니다."),
    NOT_THREE_DIGITS_NUMBER("3자리의 정수여야만 합니다."),
    ZERO_INCLUDED("0이 포함된 수는 사용할 수 없습니다."),
    DUPLICATED_DIGITS("각 자리의 수는 모두 달라야 합니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

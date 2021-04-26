package baseball.domain;

public enum EndType {
    RE_RUN("1"),
    SYSTEM_EXIT("2");

    private String type;

    EndType(final String type) {
        this.type = type;
    }

    public static EndType findEndType(final String type) {
        if (!RE_RUN.type.equals(type) && !SYSTEM_EXIT.type.equals(type)) {
            throw new IllegalArgumentException("유효하지 않은 종료타입 입니다.");
        }
        return RE_RUN.type.equals(type) ? RE_RUN : SYSTEM_EXIT;
    }
}

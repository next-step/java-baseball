package baseball.common;

public enum ResultEnum {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ;

    private String message;

    ResultEnum(final String message) {
        this.message = message;
    }

    public String getMessage(final int count) {
        return count == 0 ? "" : count + this.message;
    }

    public String getMessage() {
        return this.message;
    }

}

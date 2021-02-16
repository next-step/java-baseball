package domain;

public enum Result {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResult(Integer count) {
        if (count != 0) {
            return count.toString() + this.message;
        }
        return "";
    }
}

public enum BallCountMessage {

    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    ;

    private final String message;

    BallCountMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

package baseball.model.shot;

public enum Shot {
    OUT(""), BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

    private final String message;

    Shot(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
package baseball.domain.player;

public enum PlayStatus {
    PLAY("1"), STOP("2");

    private final String value;

    PlayStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PlayStatus getPlayStatus(String value) {
        for (PlayStatus v : values())
            if (v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}

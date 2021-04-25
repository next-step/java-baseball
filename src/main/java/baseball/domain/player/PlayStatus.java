package baseball.domain.player;

public enum PlayStatus {
    PLAY(true), STOP(false);

    private final boolean value;

    PlayStatus(boolean value) {
        this.value = value;
    }
}

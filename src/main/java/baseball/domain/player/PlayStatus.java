package baseball.domain.player;

public enum PlayStatus {
    PLAY(true), STOP(false);

    private final boolean isPlaying;

    PlayStatus(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}

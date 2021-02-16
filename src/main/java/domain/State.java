package domain;

public enum State {
    PLAY(1),
    END(2);

    private final int playOption;

    State(final int playOption) {
        this.playOption = playOption;
    }

    public int getOption() {
        return playOption;
    }
}

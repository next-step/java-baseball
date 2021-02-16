package domain;

import java.util.HashMap;
import java.util.Map;

public enum State {
    PLAY(1),
    END(2);

    private final int playOption;
    private static Map map = new HashMap<>();

    State(final int playOption) {
        this.playOption = playOption;
    }

    public int getOption() {
        return playOption;
    }

    public static State valueOf(int playOption) {
        return (State) map.get(playOption);
    }

    public int getValue() {
        return playOption;
    }
}

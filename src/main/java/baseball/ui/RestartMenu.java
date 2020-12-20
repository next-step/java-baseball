package baseball.ui;

import java.util.Objects;

public enum RestartMenu {
    RESTART("1"),
    EXIT("2");

    private final String value;

    RestartMenu(String value) {
        this.value = value;
    }

    public static RestartMenu getMatching(String input) {
        RestartMenu menu = EXIT;
        for (RestartMenu candidate : values()) {
            menu = replaceOrDefault(menu, candidate, input);
        }
        return menu;
    }

    private static RestartMenu replaceOrDefault(RestartMenu menu, RestartMenu candidate, String input) {
        if (Objects.equals(candidate.value, input)) {
            return candidate;
        }
        return menu;
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}

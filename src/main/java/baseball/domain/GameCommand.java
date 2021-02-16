package baseball.domain;

import java.util.Arrays;

public enum GameCommand {
    RESTART("1"),
    END("2");

    private static final String INVALID_COMMAND_MESSAGE = "잘못된 값을 입력했습니다. 1 or 2를 입력해 주세요";
    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand check(String input) {
        return Arrays.stream(GameCommand.values())
                .filter(it -> it.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

}

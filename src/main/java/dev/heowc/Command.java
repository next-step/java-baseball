package dev.heowc;

import java.util.HashMap;
import java.util.Map;

public enum Command {

    START(1),
    END(2);

    private final int code;

    private static final Map<Integer, Command> CODE_MAP;

    static {
        final Command[] commands = values();
        final Map<Integer, Command> codeMap = new HashMap<>(commands.length);
        for (Command command : commands) {
            codeMap.put(command.code, command);
        }
        CODE_MAP = codeMap;
    }

    Command(final int code) {
        this.code = code;
    }

    public boolean isStart() {
        return this == START;
    }

    public static Command code(int rawCommand) {
        return CODE_MAP.getOrDefault(rawCommand, END);
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
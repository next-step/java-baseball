package view;

import exception.InvalidGameCommandException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum GameCommand {
    REPLAY("1"),
    EXIT("2");

    private static final Map<String, GameCommand> ENUM_MAP;
    private String value;

    public String value() {
        return value;
    }

    GameCommand(String value) {
        this.value = value;
    }

    static {
        Map<String, GameCommand> map = new HashMap<>();
        for (GameCommand command: GameCommand.values()) {
            map.put(command.value(), command);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static GameCommand get(String value) {
        GameCommand gameCommand = ENUM_MAP.get(value);
        if(gameCommand == null) throw new InvalidGameCommandException("잘못된 입력입니다.");
        return ENUM_MAP.get(value);
    }
}

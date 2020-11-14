package game.baseball.command;

import game.baseball.domain.BaseBallGame;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

public enum BaseBallGameCommand {

    RESTART(1, BaseBallGame::undoOver),

    QUIT(2, game -> {});

    private static final Map<Integer, BaseBallGameCommand> BY_COMMAND;

    static {
        BY_COMMAND = new HashMap<>();
        for (BaseBallGameCommand command : values()) {
            BY_COMMAND.put(command.getCommand(), command);
        }
    }

    private final int command;
    private final Consumer<BaseBallGame> gameConsumer;

    BaseBallGameCommand(int command, Consumer<BaseBallGame> gameConsumer) {
        this.command = command;
        this.gameConsumer = gameConsumer;
    }

    public void run(BaseBallGame game) {
        gameConsumer.accept(game);
    }

    public static BaseBallGameCommand valueOf(IntSupplier commandSupplier) {
        int command = commandSupplier.getAsInt();
        return BY_COMMAND.get(command);
    }

    private int getCommand() {
        return command;
    }
}

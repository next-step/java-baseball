package baseball.constant;

public enum GameCommandType {

    RETRY("1"),
    EXIT("2");

    private final String command;

    GameCommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean isExistType(String command) {
        GameCommandType[] gameCommandTypes = GameCommandType.values();
        for (GameCommandType gameCommandType : gameCommandTypes) {
            if (command.equals(gameCommandType.getCommand())) {
                return true;
            }
        }
        return false;
    }


}

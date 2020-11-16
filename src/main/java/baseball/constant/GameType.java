package baseball.constant;

public enum GameType {

    RETRY("1"),
    EXIT("2");

    private final String command;

    GameType(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static boolean isExistType(String command){
        GameType[] gameTypes = GameType.values();
        for(GameType gameType : gameTypes){
            if(command.equals(gameType.getCommand())){
                return true;
            }
        }
        return false;
    }


}

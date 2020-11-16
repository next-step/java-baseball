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

}

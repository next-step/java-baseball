package game;

public class GameOption {
    private String continueHotKey = "1";
    private String exitHotKey = "2";

    public boolean isExit(String input) {
        return this.exitHotKey.equals(input);
    }

    public boolean isContinue(String input) {
        return this.continueHotKey.equals(input);
    }

    public String getExitHotKey() {
        return exitHotKey;
    }

    public String getContinueHotKey() {
        return continueHotKey;
    }

}

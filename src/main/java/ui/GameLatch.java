package ui;

public class GameLatch {
    private static final String GAME_END_FLAG = "2";

    private boolean continued;

    GameLatch(boolean continued) {
        this.continued = continued;
    }

    public static GameLatch of() {
        return new GameLatch(true);
    }

    public void judgeKeepGoing(String flag) {
        if (flag.equals(GAME_END_FLAG)) {
            this.continued = false;
        }
    }

    public boolean isContinued() {
        return continued;
    }
}

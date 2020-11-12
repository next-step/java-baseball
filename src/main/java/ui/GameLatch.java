package ui;

import ui.exceptions.IllegalGameLatchFlagException;

public class GameLatch {
    private static final String GAME_END_FLAG = "2";
    private static final String GAME_CONTINUE_FLAG = "1";

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
        if (flag.equals(GAME_CONTINUE_FLAG)) {
            this.continued = true;
        }
        throw new IllegalGameLatchFlagException();
    }

    public boolean isContinued() {
        return continued;
    }
}

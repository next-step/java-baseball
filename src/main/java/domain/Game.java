package domain;

public class Game {

    private final boolean isFinish;

    public Game() {
        this.isFinish = false;
    }

    public boolean isRunning() {
        return !isFinish;
    }
}

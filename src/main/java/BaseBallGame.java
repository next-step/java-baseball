public class BaseBallGame {
    private boolean isRunning;

    public BaseBallGame() {
        this.isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}

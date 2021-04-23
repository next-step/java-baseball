public class BaseBallGame {
    private boolean isRunning;

    public BaseBallGame() {
        this.resetGame();
    }

    public void resetGame() {
        this.setRunning(true);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}

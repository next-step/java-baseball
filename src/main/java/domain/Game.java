package domain;

public class Game {

    private boolean isFinish;

    public Game() {
        this.isFinish = false;
    }

    public boolean isRunning() {
        return !isFinish;
    }

    public void setFinish(MenuNumber menuNumber) {
        if (menuNumber.getMenu().equals("2")) {
            isFinish = true;
        }
    }
}

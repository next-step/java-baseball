public class BaseballGame {

    private static BaseballGame instance;

    private BaseballGame() { }

    public static BaseballGame getInstance() {
        if (instance == null) {
            instance = new BaseballGame();
        }

        return instance;
    }

    public void run() {
        do {
            // do something...
        } while(restart());

        exitGame();
    }

    private boolean restart() {

        // do something...

        return false;
    }

    private void exitGame() {
        // do something...
    }
}

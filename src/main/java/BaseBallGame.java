import java.util.Scanner;

public class BaseBallGame {
    private boolean isRunning;
    Message message;

    public BaseBallGame(Message message) {
        this.message = message;
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

    public String getInput() {
        message.getInput();

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        return input;
    }

    public void checkAnswer(String input) {
        this.setRunning(false);
    }
}

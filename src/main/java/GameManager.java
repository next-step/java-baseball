import java.util.Scanner;

public abstract class GameManager {
    public static Scanner userInput = new Scanner(System.in);
    protected Game game;

    public void gameProcess(Game game){
        this.game = game;
        startGame();
        endGame();
    }

    public abstract void startGame();
    public abstract void endGame();
}

import java.util.Scanner;

public abstract class GameManager {
    public static Scanner userInput = new Scanner(System.in);
    protected Game game;

    public void gameProcess(Game game){
        this.game = game;
        gameStart();
        gameEnd();
    }

    public abstract void gameStart();
    public abstract void gameEnd();
}

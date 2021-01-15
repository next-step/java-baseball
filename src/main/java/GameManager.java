import java.util.Scanner;

public abstract class GameManager {
    public static Scanner userInput = new Scanner(System.in);

    public void gameProcess(){
        gameStart();
        gameEnd();
    }

    public abstract void gameStart();
    public abstract void gameEnd();
}

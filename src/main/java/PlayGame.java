import java.util.Scanner;

public class PlayGame {

    public static final int RANDOM_NUMBER_LENGTH = 3;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new BaseBallGameManager().start();
    }
}

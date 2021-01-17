package baseball;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserIO userIO = new UserIO(scanner);
        Number.Builder numberBuilder = new Number.Builder();

        Game game = new Game(userIO, numberBuilder);
        game.start();
    }
}

package baseball;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        Scanner scanner = new Scanner(System.in);
        runLoop(model, scanner);
    }

    private static void runLoop(GameModel model, Scanner scanner) {
        while (model.isComplete() == false) {
            System.out.print(model.flushOutput());
            scanner.nextLine();
        }
    }
}

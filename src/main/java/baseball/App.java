package baseball;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GameModel model = new GameModel(new NumberGenerator());
        Scanner scanner = new Scanner(System.in);
        runLoop(model, scanner);
    }

    private static void runLoop(GameModel model, Scanner scanner) {
        while (model.isComplete() == false) {
            System.out.print(model.flushOutput());
            model.input(scanner.nextLine());
        }
    }
}

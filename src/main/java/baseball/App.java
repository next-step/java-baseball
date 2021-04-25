package baseball;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GameModel model = new GameModel(new NumberGenerator());
        Scanner scanner = new Scanner(System.in);
        try {
            runLoop(model, scanner);
        } catch (AbnormalInputException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("게임을 종료합니다.");
    }

    private static void runLoop(GameModel model, Scanner scanner) {
        while (model.isComplete() == false) {
            System.out.print(model.flushOutput());
            model.input(scanner.nextLine());
        }
    }
}

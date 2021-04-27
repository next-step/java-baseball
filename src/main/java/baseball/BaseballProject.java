package baseball;

import java.util.Scanner;

public class BaseballProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballUi ui = new BaseballUi(scanner);
        BaseballService service = new BaseballService();

        service.startGame(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);
        try {
            service.checkNumbers(ui.askNumber());
        } catch (Exception e) {
            ui.showMessage(e.getMessage());
            service.checkNumbers(ui.askNumber());
        }

        scanner.close();
    }
}   
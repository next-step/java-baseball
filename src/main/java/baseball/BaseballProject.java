package baseball;

import java.util.Scanner;

import baseball.model.BaseballResult;

public class BaseballProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballUi ui = new BaseballUi(scanner);
        BaseballService service = new BaseballService();
        BaseballResult result;

        service.startGame(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);
        do {
            result = playGame(ui, service);
        } while (!result.isFinish());

        scanner.close();
    }

    public static BaseballResult playGame(BaseballUi ui, BaseballService service) {
        BaseballResult result;

        try {
            result = service.checkNumbers(ui.askNumber());
        } catch (Exception e) {
            ui.showMessage(e.getMessage());
            result = new BaseballResult();
        }

        ui.showMessage(result.getResultMessage());
        return result;
    }
}   
package baseball;

import java.util.Scanner;

import baseball.business.BaseballService;
import baseball.business.BaseballUi;
import baseball.etc.Constants;
import baseball.model.BaseballResult;

public class BaseballProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballUi ui = new BaseballUi(scanner);
        BaseballService service = new BaseballService();

        do {
            initGame(ui, service);
        } while (Constants.COUNTINUE.equals(ui.askContinue()));
        //continueGame(ui, service);

        scanner.close();
    }

    /**
     * 게임 시작.
     * @param ui UI 로직 객체.
     * @param service 일반 로직 객체.
     */
    public static void initGame(BaseballUi ui, BaseballService service) {
        BaseballResult result;

        service.startGame(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);
        do {
            result = playGame(ui, service);
        } while (!result.isFinish());
    }

    /**
     * 게임 실행.
     * @param ui UI 로직 객체.
     * @param service 일반 로직 객체.
     * @return 게임 결과.
     */
    public static BaseballResult playGame(BaseballUi ui, BaseballService service) {
        BaseballResult result;

        try {
            result = service.checkNumbers(ui.askNumber());
        } catch (Exception e) {
            ui.showMessage(e.getMessage());
            return new BaseballResult();
        }

        ui.showMessage(result.getResultMessage());
        return result;
    }

    /**
     * 게임 재실행.
     * @param ui UI 로직 객체.
     * @param service 일반 로직 객체.
     */
    public static void continueGame(BaseballUi ui, BaseballService service) {
        if (Constants.COUNTINUE.equals(ui.askContinue())) {
            initGame(ui, service);
        }
    }
}
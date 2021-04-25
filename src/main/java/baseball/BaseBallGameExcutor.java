package baseball;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameExcutor {
    private static final String GAME_OVER = "2";
    private static final String DEFAULT = "1";
    private static final InputView inputview = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private BaseBallGameExcutor() {
    }

    private static void gameProgress(Computer computer) {
        Result result = new Result();
        while (!result.isEnd()) {
            BallNumbers numbers = inputview.getUserNumbers();
            result = computer.match(numbers);
            outputView.drawResult(result);
        }
    }

    public void start() {
        String gameStatus = DEFAULT;
        while(!gameStatus.equals(GAME_OVER)) {
            Computer computer = new Computer(new AutoNumbersStratgy().generate());
            gameProgress(computer);
            gameStatus = inputview.getGameStart();
        }
    }

    public static void main(String[] args) {
        new BaseBallGameExcutor().start();
    }
}

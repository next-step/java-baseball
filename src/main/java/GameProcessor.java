import domain.AutoChoiceStrategy;
import domain.Computer;
import domain.Numbers;
import domain.Result;
import view.InputView;
import view.OutputView;

public class GameProcessor {

    public static void start () {
        boolean isProgress = true;
        while (isProgress) {
            Computer computer = peekNumbers();
            gameProgress(computer);
            isProgress = InputView.getMoreGame();
        }
    }

    private static Computer peekNumbers() {
        return new Computer(new AutoChoiceStrategy().generate());
    }

    private static void gameProgress(Computer computer) {
        Result result = new Result();
        while (!result.isGameEnd()) {
            Numbers numbers = InputView.getUserNumbers();
            result = computer.matches(numbers);
            OutputView.showResult(result);
        }
    }
}

import model.domain.BallFactory;
import model.domain.Balls;
import model.domain.BaseballGame;
import model.domain.Record;
import view.InputView;
import view.OutputView;

public class BaseballApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        BaseballGame game = new BaseballGame(BallFactory.createBalls());

        while (!game.isEnd()) {
            String inputNumbers = InputView.inputNumber();

            Record record = game.play(Balls.of(inputNumbers));
            OutputView.printRecord(record);
        }

        if (InputView.restart()) {
            start();
        }
    }
}

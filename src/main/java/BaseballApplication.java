import model.domain.BallFactory;
import model.domain.Balls;
import model.domain.BaseballGame;
import model.domain.Record;
import view.InputView;
import view.OutputView;

public class BaseballApplication {

    public static void main(String[] args) {

        BaseballGame game = new BaseballGame(BallFactory.createBalls());

        do {
            if (game.isEnd()) {
                game = new BaseballGame(BallFactory.createBalls());
            }

            String inputNumbers = InputView.inputNumber();

            Record record = game.play(Balls.of(inputNumbers));
            OutputView.printRecord(record);
        } while (!game.isEnd() || (game.isEnd() && InputView.restart()));
    }
}

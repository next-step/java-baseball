package baseball.ui;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import baseball.domain.BallNumbers;
import baseball.domain.Bat;
import baseball.domain.score.Nothing;
import baseball.domain.score.Score;
import baseball.domain.score.ScoreCalculator;
import baseball.domain.score.Win;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private static final int EXIT_INPUT = 1;

    public void start() {
        BallNumbers ballNumbers = BallGenerator.getBallNumbers();
        Ball ball = new Ball(ballNumbers);
        Score score = new Nothing();
        playGame(ball, score);

        if (InputView.askReplay() == EXIT_INPUT) {
            start();
        }
    }

    private void playGame(Ball ball, Score score) {
        while (!(score instanceof Win)) {
            BallNumbers playerInput = new BallNumbers(InputView.askBatInput());
            Bat bat = new Bat(playerInput);
            ScoreCalculator scoreCalculator = new ScoreCalculator();
            scoreCalculator.calculateScore(bat, ball);
            score = scoreCalculator.getScore();
            OutputView.printScore(score);
        }
    }
}

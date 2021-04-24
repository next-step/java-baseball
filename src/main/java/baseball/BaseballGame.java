package baseball;

import baseball.domain.Player;
import baseball.ui.InputView;
import baseball.ui.ResultView;
import baseball.utils.RandomNumbersGenerator;

public class BaseballGame {
    private static final int MAX_PITCH_SIZE = 3;

    private Player player;

    public BaseballGame() {
        player = Player.of(RandomNumbersGenerator.generateStringNumbers(MAX_PITCH_SIZE));
    }

    public void run() {
        do {
            player.play(InputView.inputPitchNumbers());
            ResultView.printPlayResult(player.result());
        } while(!player.isFinished());
        ResultView.printEndGame();
    }
}

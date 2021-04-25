package baseball;

import baseball.domain.Player;
import baseball.domain.ProgressType;
import baseball.ui.InputView;
import baseball.ui.ResultView;
import baseball.utils.RandomNumbersGenerator;

public class BaseballGame {
    private static final int MAX_PITCH_SIZE = 3;

    private Player player;
    private ProgressType progressType;

    public BaseballGame() {
    }

    public void run() {
        do {
            player = Player.of(RandomNumbersGenerator.generateStringNumbers(MAX_PITCH_SIZE));
            play();
            progressType = ProgressType.of(InputView.inputReplay());
        } while(progressType.progress());
    }

    public void play() {
        do {
            player.play(InputView.inputPitchNumbers());
            ResultView.printPlayResult(player.result());
        } while(!player.isFinished());
        ResultView.printEndGame();
    }
}

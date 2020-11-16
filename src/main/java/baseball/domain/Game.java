package baseball.domain;

import baseball.view.ConsoleView;
import baseball.view.GameView;

public class Game {
    public static final Integer BASEBALL_NUMBER_SIZE = 3;

    private final Player player;
    private final Adversary adversary;
    private final GameView gameView = new ConsoleView();

    public Game(Adversary adversary, Player player) {
        this.player = player;
        this.adversary = adversary;
        adversary.chooseNumber();
    }

    public void play() {
        Number number = player.inputNumber(gameView);
        Hint hint = adversary.getHint(number);
        gameView.showHint(hint);
        if (hint.isAllStrike()) {
            gameView.showEndGuide();
            return;
        }
        play();
    }
}

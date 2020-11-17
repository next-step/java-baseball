package baseball.domain;

import baseball.view.ConsoleView;
import baseball.view.GameView;

/**
 * 야구 게임 한 판을 의미한다.
 * 야구 게임에는 플레이어와 상대방이 필수이다.
 *
 * @author  Yonggu Han
 */
public class Game {
    public static final Integer BASEBALL_NUMBER_SIZE = 3;

    private final Player player;
    private final Adversary adversary;
    private final GameView gameView = new ConsoleView();  // Game 내에서 입출력을 담당한다.

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

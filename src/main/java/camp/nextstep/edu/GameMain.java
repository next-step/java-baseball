package camp.nextstep.edu;

import camp.nextstep.edu.game.BaseballGame;
import camp.nextstep.edu.game.Game;

public class GameMain {

    public static void main(String[] args) {
        Game game = new BaseballGame();
        game.start();
    }
}

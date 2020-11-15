package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;

public class BaseballApplication {

    public static void main(String[] args) {
        GameService service = new GameService();
        GameController game = new GameController(service);
        game.start();
    }

}

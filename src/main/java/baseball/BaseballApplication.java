package baseball;

import baseball.service.GameService;

public class BaseballApplication {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }
}

package baseball;

import baseball.service.BaseballService;

public class Main {
    static public void main(String[] args) {
        BaseballService baseballService = new BaseballService();
        baseballService.startGame();
    }
}

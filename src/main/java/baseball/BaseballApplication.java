package baseball;

import baseball.service.BaseBallService;

public class BaseballApplication {

    public static void main(String[] args) {
        BaseBallService baseBallService = new BaseBallService();
        baseBallService.start();
    }
}

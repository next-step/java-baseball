package baseball;

import baseball.config.BaseballConfig;
import baseball.ui.BaseballController;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballConfig config = new BaseballConfig();
        BaseballController controller = config.baseballController();

        controller.startGame();
    }
}

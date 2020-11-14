package baseball;

import baseball.application.BaseballService;
import baseball.domain.BaseBallGenerator;
import baseball.infra.Computer;
import baseball.ui.BaseballController;

public class BaseballConfig {
    public BaseballController baseballController() {
        return new BaseballController(baseballService());
    }

    private BaseballService baseballService() {
        return new BaseballService(baseBallGenerator());
    }

    private BaseBallGenerator baseBallGenerator() {
        return new Computer();
    }
}

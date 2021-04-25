package baseball.config;

import baseball.domain.strategy.BaseballGenerator;
import baseball.domain.strategy.BaseballRandomGenerator;
import baseball.service.BaseballService;
import baseball.ui.BaseballController;
import baseball.view.*;

public class BaseballConfig {

    public BaseballController baseballController() {
        return new BaseballController(baseballView(), baseballService());
    }

    private BaseballService baseballService() {
        return new BaseballService(baseballGenerator());
    }

    private BaseballGenerator baseballGenerator() {
        return new BaseballRandomGenerator();
    }

    private BaseballView baseballView() {
        return new BaseballViewImpl(inputView(), resultView());
    }

    private ResultView resultView() {
        return BaseballResultView.getInstance();
    }

    private InputView inputView() {
        return BaseballInputView.getInstance();
    }
}

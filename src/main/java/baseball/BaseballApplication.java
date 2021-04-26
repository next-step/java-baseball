package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballControllerTemplate;
import baseball.controller.impl.BaseballController;
import baseball.view.BaseballView;
import baseball.view.impl.BaseballViewImpl;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballConfig config = BaseballConfig.builder().build();
        BaseballView baseballView = new BaseballViewImpl(config);
        BaseballControllerTemplate baseballController = new BaseballController(baseballView);

        baseballController.run(config);
    }



}

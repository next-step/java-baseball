package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballControllerTemplate;
import baseball.controller.impl.BaseballController;
import baseball.view.BaseballView;
import baseball.view.impl.BaseballViewImpl;

public class BaseballApplication {
    private static BaseballView baseballView = new BaseballViewImpl();
    private static BaseballControllerTemplate baseballControllerTemplate = new BaseballController(baseballView);
    private static BaseballConfig config = new BaseballConfig(3,16, 3);

    public static void main(String[] args) {
        BaseballApplication.run(BaseballApplication.class, args);
    }

    static public <T> void run(Class<T> clazz, String[] args) {
        baseballControllerTemplate.run(config);
    }
}

package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballControllerTemplate;
import baseball.controller.impl.BaseballController;
import baseball.view.BaseballView;
import baseball.view.impl.BaseballViewImpl;

import java.util.Locale;

public class BaseballApplication {
    private static BaseballConfig config
            = BaseballConfig.builder()
                                .size(3)
                                .radix(10)
                                .tryCount(0)
                                .locale(Locale.ENGLISH)
                                .build();
    private static BaseballView baseballView = new BaseballViewImpl(config);
    private static BaseballControllerTemplate baseballControllerTemplate = new BaseballController(baseballView);

    public static void main(String[] args) {
        BaseballApplication.run(BaseballApplication.class, args);
    }

    static public <T> void run(Class<T> clazz, String[] args) {
        baseballControllerTemplate.run(config);
    }
}

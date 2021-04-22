package baseball.view;

import baseball.application.BaseballService;
import baseball.domain.BaseballNumbers;

public class BaseballView {
    private final BaseballService baseballService = new BaseballService();

    public BaseballView() {
    }

    public void start() {
        boolean isContinued = true;
        while(isContinued == Boolean.TRUE) {
            BaseballNumbers answer = this.baseballService.generateAnswer();
            isContinued = Boolean.FALSE;
        }
    }
}

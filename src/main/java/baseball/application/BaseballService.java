package baseball.application;

import baseball.domain.BaseballNumbers;
import baseball.util.BaseballNumberFactory;

public class BaseballService {
    private BaseballNumberFactory baseballNumberFactory;

    public BaseballService() {
        baseballNumberFactory = new BaseballNumberFactory();
    }

    public BaseballNumbers generateAnswer() {
        return this.baseballNumberFactory.generateNumbers();
    }
}

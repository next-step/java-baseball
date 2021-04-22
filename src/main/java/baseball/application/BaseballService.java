package baseball.application;

import baseball.domain.BaseballNumbers;
import baseball.util.BaseballNumberFactory;

public class BaseballService {
    private final BaseballNumberFactory baseballNumberFactory = new BaseballNumberFactory();

    public BaseballService() {
    }

    public BaseballNumbers generateAnswer() {
        return this.baseballNumberFactory.generateNumbers();
    }
}

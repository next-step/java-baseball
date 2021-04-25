package baseball.application;

import baseball.domain.BaseballNumbers;
import baseball.domain.Score;
import baseball.util.BaseballException;
import baseball.util.BaseballNumberFactory;

public class BaseballService {
    private BaseballNumberFactory baseballNumberFactory;

    public BaseballService() {
        baseballNumberFactory = new BaseballNumberFactory();
    }

    public BaseballNumbers generateAnswer() {
        return this.baseballNumberFactory.generateNumbers();
    }

    public Score scorePlayerInput(String playerInput) {
        try {
            BaseballNumbers playerBaseballNumber = new BaseballNumbers(playerInput);
        } catch (BaseballException e) {
            System.out.println(e.getMessage());
        }

        return null; // TODO 기능 미구현으로 NULL 반환
    }
}

package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.service.BaseBallService;
import baseball.type.ResultType;
import baseball.view.UserInputView;

public class BaseballApplication {

    public static void main(String[] args) {
        BaseBallService baseBallService = new BaseBallService();
        baseBallService.start();
    }
}

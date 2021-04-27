package baseball;

import baseball.domain.core.BaseballNos;
import baseball.domain.core.BaseballResult;
import baseball.ui.BaseballGamePlayerInput;

import static baseball.ui.BaseballGameDisplay.display;
import static baseball.ui.BaseballGamePlayerInput.inputBaseballNos;

public class BaseballGameApplication {
    public static void main(String[] args) {
        BaseballNos computer = BaseballNos.formComputer();

        boolean loop = true;
        while(loop) {
            BaseballResult baseballResult = inputBaseballNos()
                    .compareTo(computer);
            display(baseballResult);
            if (baseballResult.isPerfectMatch()){
                loop = BaseballGamePlayerInput.inputRetryBaseballGame();
                computer = BaseballNos.formComputer();
            }
        }
    }
}

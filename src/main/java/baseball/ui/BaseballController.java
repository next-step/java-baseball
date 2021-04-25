package baseball.ui;

import baseball.domain.BallNumbers;
import baseball.domain.dto.BaseballResultResponse;
import baseball.service.BaseballService;
import baseball.view.BaseballView;

import java.util.List;

import static baseball.domain.ProcessType.CONTINUE;

public class BaseballController {
    private final BaseballView baseballView;
    private final BaseballService baseballService;

    public BaseballController(BaseballView baseballView, BaseballService baseballService) {
        this.baseballView = baseballView;
        this.baseballService = baseballService;
    }

    public void startGame() {
        BallNumbers computedNumbers = baseballService.generateComputedNumbers();

        loopQuestion(computedNumbers);

        int nextProcess = baseballView.questionNextProcess();
        if (nextProcess == CONTINUE.flagNumber()) {
            startGame();
        }
        stopGame();
    }

    private void loopQuestion(BallNumbers computedNumbers) {
        List<Integer> inputNumbers = baseballView.questionNumbers();
        BaseballResultResponse response = baseballService.matchesBallNumbers(computedNumbers, inputNumbers);
        baseballView.showPitchingResult(response);

        if (!response.isAllStrike()) {
            loopQuestion(computedNumbers);
        }
    }

    private void stopGame() {
        System.exit(0);
    }

}

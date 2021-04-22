package baseball.controller.impl;

import baseball.controller.BaseballControllerTemplate;
import baseball.model.BaseballNumber;
import baseball.model.BaseballResult;
import baseball.view.BaseballView;

public class BaseballController extends BaseballControllerTemplate {
    private BaseballView baseballView;
    private BaseballNumber answer;

    public BaseballController(BaseballView baseballView) {
        this.baseballView = baseballView;
    }

    @Override
    public void initGame(int size, int radix) {
        answer = BaseballNumber.builder()
                .size(size)
                .radix(radix)
                .build();
        System.out.println(answer);
    }

    @Override
    public BaseballNumber readInputBaseballNumber() {
        baseballView.printInputPrompt();

        String input = baseballView.readInputPrompt();

        return new BaseballNumber(input, this.answer.getSize(), this.answer.getRadix());
    }

    @Override
    public BaseballResult checkTrial(BaseballNumber baseballNumber) {
        return BaseballResult.calcResult(this.answer, baseballNumber);
    }

    @Override
    public void printBaseballResult(BaseballResult baseballResult) {
        this.baseballView.printBaseballResult(baseballResult);
    }

    @Override
    public void printGameResult(BaseballResult baseballResult) {
        baseballView.printGameResult(baseballResult);
    }

    @Override
    public boolean askReGame() {
        baseballView.printAskingReGame();
        String input = baseballView.readInputPrompt().trim();
        return "1".equals(input);
    }
}

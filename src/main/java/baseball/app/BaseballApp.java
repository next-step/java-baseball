package baseball.app;


import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballApp {

    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            start();
            isContinue = InputView.getContinue();
        }
    }

    private static void start() {
        BaseballNumbers compare = BaseballNumbers.ofRandom();
        boolean isEnd = false;
        while (!isEnd) {
            BaseballNumbers target = BaseballNumbers.ofUserInput(InputView.getNumbers());
            BaseballResult result = compare.compareBaseballNumbers(target);
            OutputView.print(result);
            isEnd = result.isEnd();
        }
    }

}

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
        // TODO: 랜덤값 생성
        BaseballNumbers compare = BaseballNumbers.of(1, 2, 3);
        boolean isEnd = false;
        while (!isEnd) {
            BaseballNumbers target = BaseballNumbers.ofUserInput(InputView.getNumbers());
            BaseballResult result = compare.compareBaseballNumbers(target);
            OutputView.print(result);
            isEnd = result.isEnd();
        }
    }

}

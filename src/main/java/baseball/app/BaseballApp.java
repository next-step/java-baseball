package baseball.app;


import baseball.domain.BaseballNumbers;
import baseball.domain.ResultType;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class BaseballApp {

    public static void main(String[] args) {
        BaseballNumbers compare = BaseballNumbers.of(1, 2, 3);
        boolean isEnd = false;
        while (!isEnd) {
            BaseballNumbers target = BaseballNumbers.ofUserInput(InputView.getNumbers());
            Map<ResultType, Integer> result = compare.compareBaseballNumbers(target);
            OutputView.print(result);
            isEnd = result.getOrDefault(ResultType.STRIKE, 0) == 3;
        }
    }

}

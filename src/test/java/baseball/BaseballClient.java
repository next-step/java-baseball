package baseball;

import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;
import java.util.Map;

public class BaseballClient {
    public static void main(String[] args) {
        Referee referee = new Referee();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        List<Integer> input = inputView.questionToList("숫자를입력해주세요: ");

        Map<String, Integer> swing = referee.decide(input);
        resultView.printBaseBall(swing);
    }
}

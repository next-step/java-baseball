package kr.aterilio.nextstep.techcamp.precourse.baseball;

import kr.aterilio.nextstep.techcamp.precourse.baseball.judge.Judgement;
import kr.aterilio.nextstep.techcamp.precourse.baseball.ui.InputView;
import kr.aterilio.nextstep.techcamp.precourse.baseball.ui.ResultView;

import java.util.HashSet;
import java.util.List;

public class BaseballGame {

    private static final String MSG_EXCEPTION = "There are duplicate numbers in arguments.";

    private final Baseball baseball;

    public BaseballGame() {
        baseball = new Baseball();
    }

    public void start(InputView inputView) {
        boolean isClear = false;
        do {
            List<Integer> inputs = inputView.input();
            isClear = hit(inputs);
        } while (!isClear);
    }

    private boolean hit(List<Integer> inputs) {
        Judgement judgement = judge(inputs);
        print(judgement);
        return judgement.isClear();
    }

    private void print(Judgement judgement) {
        ResultView resultView = new ResultView();
        resultView.printResult(judgement);
    }

    public Judgement judge(List<Integer> inputs) {
        if ( !isValid(inputs) ) {
            throw new IllegalArgumentException(MSG_EXCEPTION);
        }
        return baseball.judge(inputs);
    }

    private boolean isValid(List<Integer> inputs) {
        HashSet<Integer> hashSet = new HashSet<>(inputs);
        return hashSet.size() == inputs.size();
    }

    @Override
    public String toString() {
        return baseball.toString();
    }
}

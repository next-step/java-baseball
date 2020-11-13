package nextstep.precourse;

import nextstep.precourse.controller.BaseballGameController;
import nextstep.precourse.view.InputView;
import nextstep.precourse.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BaseballGameController.play(new InputView(), new OutputView());
    }
}

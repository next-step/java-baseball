package application;

import ui.InputView;
import ui.OutputView;

public class BaseballGame implements Game {
    @Override
    public void run() {
        String inputString = InputView.inputString();
        OutputView.output(inputString);
    }
}

package process;

import ui.Presentator;

public class ProcessController {

    Presentator presentator;

    public ProcessController(Presentator presentator) {
        this.presentator = presentator;
    }

    public void inputValueByUser() {
        String inputValue = presentator.presentInputNumber();
    }
}

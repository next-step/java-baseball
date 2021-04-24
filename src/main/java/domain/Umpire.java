package domain;

import view.OutputMessage;

public class Umpire {


    public Umpire() {
    }

    public void requestInput() {
        OutputMessage.printMessage(OutputMessage.Message.REQUEST_INPUT);
    }
}

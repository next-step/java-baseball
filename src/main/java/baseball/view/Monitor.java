package baseball.view;

import baseball.value.Message;
import baseball.utils.PrintUtils;
import baseball.value.Result;

public class Monitor {

    public int askAnswer() {
        return PrintUtils.requestInput(Message.USER_INPUT);
    }

    public void showResult(Result result) {
        if (result.isNothing()) {
            System.out.println(Message.NOTHING);
            return;
        }

        System.out.printf(Message.RESULT, result.getStrike(), result.getBall());
    }
}

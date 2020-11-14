package baseball;

import baseball.dto.Request;
import baseball.dto.Response;
import baseball.ui.BaseballController;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballApplication {
    private static final int CONTINUE = 1;
    private static final int END = 2;

    public static void main(String[] args) {
        boolean finish = false;
        while (!finish) {
            int command = baseball();
            finish = isFinish(command);
        }
    }

    private static int baseball() {
        BaseballConfig baseballConfig = new BaseballConfig();
        BaseballController baseballController = baseballConfig.baseballController();

        Request request = new Request(InputView.input());
        Response response = baseballController.play(request);
        ResultView.print(response);

        while (!response.isFinish()) {
            response = baseballController.play(new Request(InputView.input()));
            ResultView.print(response);
        }

        return InputView.command();
    }

    private static boolean isFinish(final int command) {
        if (command == CONTINUE) {
            return false;
        }

        if (command == END) {
            return true;
        }

        throw new IllegalArgumentException("잘못된 커맨드입니다.");
    }
}

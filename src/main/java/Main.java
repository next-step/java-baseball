import ui.InputView;
import ui.ResultView;

public class Main {
    public static void main(String[] args) {
        boolean isEnd = false;

        while (!isEnd) {
            int number = InputView.inputNumber();

            ResultView.endMessage();
            int button = InputView.restartOrEnd();
            if (button == 2) {
                isEnd = true;
            }
        }
    }
}

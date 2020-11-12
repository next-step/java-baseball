import ui.InputView;

public class Main {
    public static void main(String[] args) {
        boolean isEnd = false;

        while (!isEnd) {
            int number = InputView.inputNumber();
            isEnd = true;
        }
    }
}

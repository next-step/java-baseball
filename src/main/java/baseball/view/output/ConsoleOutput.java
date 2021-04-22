package baseball.view.output;

import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;

public class ConsoleOutput implements Output {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printValiedateNumber(int numberSize) {
        System.out.println(PLEASE_INPUT_VALID_NUMBERS);
    }
}

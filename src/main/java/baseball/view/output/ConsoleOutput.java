package baseball.view.output;

import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;
import static baseball.view.output.OutputMessages.END_GAME;
import static baseball.view.output.OutputMessages.RE_START;

public class ConsoleOutput implements Output {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printValiedateNumber(int numberSize) {
        System.out.println(PLEASE_INPUT_VALID_NUMBERS);
    }

    @Override
    public void printEndMessage() {
        System.out.println(END_GAME);
        System.out.println(RE_START);
    }

}

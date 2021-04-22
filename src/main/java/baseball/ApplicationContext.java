package baseball;

import baseball.view.input.ConsoleInput;
import baseball.view.input.Input;
import baseball.view.output.ConsoleOutput;
import baseball.view.output.Output;

public class ApplicationContext {
    private final Input input;
    private final Output output;
    private final int numberSize = 3;

    public ApplicationContext() {
        this.input = new ConsoleInput(System.in);
        this.output = new ConsoleOutput();
    }

}

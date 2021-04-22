package baseball;

import baseball.controller.GameController;
import baseball.random.Random;
import baseball.random.RandomGenerator;
import baseball.view.input.ConsoleInput;
import baseball.view.input.Input;
import baseball.view.output.ConsoleOutput;
import baseball.view.output.Output;

public class ApplicationContext {
    private final Input input;
    private final Output output;
    private final Random randomGenerator;
    private final int numberSize = 3;

    public ApplicationContext() {
        this.input = new ConsoleInput(System.in);
        this.output = new ConsoleOutput();
        this.randomGenerator = new RandomGenerator();
    }

    public GameController getGameController() {
        return new GameController(input, output, numberSize, randomGenerator);
    }
}

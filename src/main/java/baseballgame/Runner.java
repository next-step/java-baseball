package baseballgame;

import baseballgame.domain.game.GameParser;
import baseballgame.ui.input.ConsoleInput;
import baseballgame.ui.input.Input;
import baseballgame.ui.output.ConsoleOutput;
import baseballgame.ui.output.Output;

public class Runner {
    private final Input INPUT;
    private final Output OUTPUT;
    private final GameParser PARSER;

    public Runner() {
        INPUT = new ConsoleInput();
        OUTPUT = new ConsoleOutput();
        PARSER = GameParser.getInstance();
    }

    public static void main(String[] args) {
        final Runner runner = new Runner();
        runner.execute();
    }

    private void execute() {
    }
}

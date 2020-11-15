package baseballgame;

import baseballgame.domain.game.BaseballGame;
import baseballgame.domain.game.Game;
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
        boolean gameExit;

        do {
            final Game startingGame = new BaseballGame(INPUT, OUTPUT);
            startingGame.run();

            gameExit = checkWhetherWantToRestartGame();
        } while (gameExit);
    }

    private boolean checkWhetherWantToRestartGame() {
        OUTPUT.demandingWhetherWantToRestartGame();

        return parserWhetherWantToRestartGame(INPUT.whetherWantToRestartGame());
    }

    private boolean parserWhetherWantToRestartGame(final String input) {
        return PARSER.whetherRestartGame(input);
    }
}

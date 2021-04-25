package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballResult;
import baseball.domain.Numbers;
import baseball.domain.Validator;
import baseball.random.Random;
import baseball.view.input.Input;
import baseball.view.output.Output;

import java.util.List;

import static baseball.view.input.InputMessages.PLEASE_INPUT_NUMBERS;

public class GameController {
    private final Input input;
    private final Output output;
    private final int ZERO = 0;
    private Random randomGenerator;
    private Numbers randomNumbers;

    public GameController(final Input input, final Output output, final Random randomGenerator) {
        this.input = input;
        this.output = output;
        this.randomGenerator = randomGenerator;
        this.randomNumbers = randomGenerator.getRandomNumber(Numbers.SIZE);
    }

    public void start() {
        final Numbers userNumbers = getUserNumbers();
        final BaseballGame game = new BaseballGame(randomNumbers, userNumbers);
        play(game);
    }

    public void reStart() {
        randomNumbers = randomGenerator.getRandomNumber(Numbers.SIZE);
        start();
    }

    private void play(final BaseballGame game) {
        while (game.isNotEnd()) {
            final BaseballResult result = game.playOneRound();
            output.printResult(result);
            start();
        }
        output.printEndMessage();
        if (input.wantRestart()) reStart();
        System.exit(ZERO);
    }

    private Numbers getUserNumbers() {
        output.print(PLEASE_INPUT_NUMBERS);
        final List<String> numbers = input.getNumbers();
        validate(numbers);
        return new Numbers(numbers);
    }

    private void validate(final List<String> numbers) {
        if (Validator.inValidate(numbers)) {
            output.printValiedateNumber();
            getUserNumbers();
        }
    }

}

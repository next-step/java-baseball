package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Numbers;
import baseball.random.Random;
import baseball.view.input.Input;
import baseball.view.output.Output;

import java.util.HashSet;
import java.util.List;

import static baseball.view.input.InputMessages.PLEASE_INPUT_NUMBERS;

public class GameController {
    private final Input input;
    private final Output output;
    private final int numberSize;
    private final int ZERO = 0;
    private Random randomGenerator;
    private Numbers numbers;

    public GameController(final Input input, final Output output, final int numberSize, final Random randomGenerator) {
        this.input = input;
        this.output = output;
        this.numberSize = numberSize;
        this.randomGenerator = randomGenerator;
        this.numbers = randomGenerator.getRandomNumber(numberSize);
    }

    public void start() {
        System.out.println("computer" + numbers);
        final Numbers userNumbers = getNumbers();
        final BaseballGame game = new BaseballGame(numbers, userNumbers);
        play(game);
    }

    private void play(final BaseballGame game) {
        while (game.isNotEnd()) {
            start();
        }
        output.printEndMessage();
        if (input.wantRestart()) reStart();
        System.exit(ZERO);
    }

    public void reStart() {
        numbers = randomGenerator.getRandomNumber(numberSize);
        start();
    }

    private Numbers getNumbers() {
        output.print(PLEASE_INPUT_NUMBERS);
        final List<String> numbers = input.getNumbers();
        validate(numbers);
        return new Numbers(numbers);
    }

    private void validate(final List<String> numbers) {
        if (validateSize(numbers) || validateDuplicate(numbers)) {
            output.printValiedateNumber(numberSize);
            getNumbers();
        }
    }

    private boolean validateSize(List<String> numbers) {
        return numbers.size() != numberSize;
    }

    private boolean validateDuplicate(List<String> numbers) {
        return new HashSet<>(numbers).size() != numberSize;
    }

}

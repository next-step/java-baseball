package me.totoku103.baseball;

import java.util.Objects;

public class Application {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;
    private final int INPUT_MAX_LENGTH = 3;
    private final Computer computer = new Computer();
    private final InputSystem inputSystem = new InputSystem(INPUT_MAX_LENGTH);

    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        final String randomDigitString = computer.generateRandomDigitString(MIN_VALUE, MAX_VALUE, INPUT_MAX_LENGTH);
        final BaseballSystem baseballSystem = new BaseballSystem(randomDigitString);

        while (!baseballSystem.isGameEnd(inputSystem.input(MessageConstants.USER_INPUT))) {
        }

        final String input = inputSystem.input(MessageConstants.GMAE_MODE);
        if (Objects.equals("1", input)) start();
    }
}

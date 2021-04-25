package domain;

import ui.IOManager;
import ui.Input;
import ui.Output;

public class BaseballGame {

    private static final String RESTART_COMMAND = "1";
    private static final String END_COMMAND = "2";

    private final Input input;
    private final Output output;
    private final NumbersGenerator numbersGenerator;

    public BaseballGame(IOManager ioManager, NumbersGenerator numbersGenerator) {
        this.input = ioManager.getInput();
        this.output = ioManager.getOutput();
        this.numbersGenerator = numbersGenerator;
    }

    public void run() {
        do {
            progress();
        } while(continueGame());
    }

    private void progress() {

        Numbers answer = new Numbers(numbersGenerator.makeNumbers());
        AnswerChecker checker = new AnswerChecker(answer);
        boolean isNotEnd;

        do {
            output.print("숫자를 입력해주세요: ");
            Numbers numbers = inputNumbers();
            isNotEnd = checkNumbers(checker, numbers);
        } while(isNotEnd);
    }

    private Numbers inputNumbers() {
        try {
            return new Numbers(input.nextInt());
        } catch (IllegalArgumentException | NullPointerException e) {
            output.printLine(e.getMessage());
        }

        return null;
    }

    private boolean checkNumbers(AnswerChecker checker, Numbers numbers) {

        if (numbers == null) {
            return true;
        }

        Hint hint = checker.makeResultHint(numbers);
        output.printLine(hint.toString());
        return hint.isNotVictory();
    }

    private boolean continueGame() {
        output.printLine("정답입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return RESTART_COMMAND.equals(inputCommand());
    }

    private String inputCommand() {
        input.nextLine();
        String command = input.nextLine();
        while (isInvalidCommand(command)) {
            output.printLine("1이나 2만 입력해주세요.");
            command = input.nextLine();
        }
        return command;
    }

    private boolean isInvalidCommand(String command) {
        return !RESTART_COMMAND.equals(command) && !END_COMMAND.equals(command);
    }
}

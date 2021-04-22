package domain;

import ui.IOManager;
import ui.Input;
import ui.Output;

public class BaseballGame {

    private final Input input;
    private final Output output;
    private final NumbersGenerator numbersGenerator;

    public BaseballGame(IOManager ioManager, NumbersGenerator numbersGenerator) {
        this.input = ioManager.input();
        this.output = ioManager.output();
        this.numbersGenerator = numbersGenerator;
    }

    public void run() {
        do {
            progress();
        } while(continueGame());
    }

    private void progress() {

        Numbers answer = new Numbers(numbersGenerator.makeNumbers());
        CorrectAnswerChecker checker = new CorrectAnswerChecker(answer);
        boolean isNotEnd;

        do {
            output.print("숫자를 입력해주세요: ");
            Numbers numbers = inputNumbers();
            isNotEnd = checkNumbers(checker, numbers);
        } while(isNotEnd);
    }

    private Numbers inputNumbers() {
        try {
            int number = input.nextInt();
            return new Numbers(number);
        } catch (IllegalArgumentException | NullPointerException e) {
            output.printLine(e.getMessage());
        }

        return null;
    }

    private boolean checkNumbers(CorrectAnswerChecker checker, Numbers numbers) {

        if (numbers == null) {
            return true;
        }

        Hint hint = checker.makeResultHint(numbers);

        if (hint == null) {
            return true;
        }

        output.printLine(hint.toString());
        return hint.isNotVictory();
    }

    private boolean continueGame() {
        output.printLine("정답입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input.nextLine();
        String command = input.nextLine();

        while (isInvalidCommand(command)) {
            output.printLine("1이나 2만 입력해주세요.");
            command = input.nextLine();
        }

        return command.equals("1");
    }

    private boolean isInvalidCommand(String command) {
        return !"1".equals(command) && !"2".equals(command);
    }
}

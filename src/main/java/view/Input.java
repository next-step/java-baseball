package view;

import domain.Number;
import domain.enums.Notice;
import util.ValidationUtil;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ValidationUtil validationUtil = new ValidationUtil();

    public Input() {
    }

    public Number number() {
        String inputNumber;
        do {
            System.out.print(Notice.INPUT_NUMBER.getMessage());
            inputNumber = scanner.next();
        } while (!validationUtil.isCorrectNumber(inputNumber));

        return new Number(inputNumber);
    }

    public boolean askContinueGame() {
        String inputAnswer;
        do {
            System.out.println(Notice.CORRECT_ALL_NUMBER.getMessage());
            System.out.println(Notice.INPUT_GAME_AGAIN.getMessage());
            inputAnswer = scanner.next();
        } while (!validationUtil.isCorrectContinueAnswer(inputAnswer));

        return "1".equals(inputAnswer);
    }
}

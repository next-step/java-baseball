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

    public Number threeDigitNumber() {
        String inputNumber;
        do {
            System.out.print(Notice.INPUT_NUMBER.getMessage());
            inputNumber = scanner.next();
        } while (!validationUtil.isCorrectNumber(inputNumber));

        return new Number(inputNumber);
    }
}

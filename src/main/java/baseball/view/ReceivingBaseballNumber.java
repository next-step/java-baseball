package baseball.view;

import java.util.Objects;
import java.util.Scanner;

public class ReceivingBaseballNumber {
    private final Scanner scanner;

    public ReceivingBaseballNumber(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveBaseballNumber() {
        String numbers;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            numbers = scanner.next();
        } while (!isNotEmptyNumber(numbers));
        return numbers;
    }

    private boolean isNotEmptyNumber(String numbers) {
        if (Objects.isNull(numbers)) {
            return false;
        }
        return isNumber(numbers);
    }

    private boolean isNumber(String numbers) {
        try {
            return parseInteger(numbers) instanceof Integer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Integer parseInteger(String numbers) {
        return Integer.parseInt(numbers);
    }
}

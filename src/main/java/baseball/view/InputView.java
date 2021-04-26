package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final Scanner scanner = new Scanner(System.in);

    public List<Integer> inputNumbers() {
        System.out.print(NUMBER_MESSAGE);
        String number = scanner.nextLine();
        return toIntegers(number);
    }

    private List<Integer> toIntegers(String number) {
        String[] digits = number.split("");
        List<Integer> numbers = new ArrayList<>();
        for (String digit : digits) {
            numbers.add(Integer.valueOf(digit));
        }
        return numbers;
    }
}

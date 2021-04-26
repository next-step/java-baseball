package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CHOOSE_TYPE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public List<Integer> inputNumbers() {
        System.out.print(NUMBER_MESSAGE);
        String number = scanner.nextLine();
        return toIntegers(number);
    }

    public String inputChooseType() {
        System.out.println(CHOOSE_TYPE_MESSAGE);
        return scanner.nextLine();
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

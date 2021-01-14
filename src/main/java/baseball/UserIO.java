package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class UserIO {
    private static final String GET_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String INPUT_ISRESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner scanner;

    public UserIO(Scanner scanner) {
        this.scanner = scanner;
    }

    // 5.2.3 : Method names are written in lowerCamelCase
    public ArrayList<Integer> inputNumber() {
        ArrayList<Integer> number = new ArrayList<>();

        System.out.print(GET_NUMBER_MSG);
        String[] strings = this.scanner.next().split("");
        for (String s : strings) {
            int val = Integer.parseInt(s);
            number.add(val);
        }
        return number;
    }

    public Boolean inputIsRestart() {
        System.out.println(INPUT_ISRESTART_MSG);
        Integer val = this.scanner.nextInt();

        return val.equals(1);
    }
}

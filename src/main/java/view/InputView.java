package view;

import domain.UserNumber;

import java.util.Scanner;

public class InputView {

    public static final String USER_NUMBER = "숫자를 입력해 주세요 : ";
    public static final String ERROR_MESSAGE = "올바른 숫자를 입력해 주세요.";
    Scanner scanner = new Scanner(System.in);

    public UserNumber getUserNumbers() {
        System.out.print(USER_NUMBER);
        UserNumber userNumber;
        try {
            userNumber = new UserNumber(scanner.nextLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(ERROR_MESSAGE);
            userNumber = getUserNumbers();
        }
        return userNumber;
    }
}

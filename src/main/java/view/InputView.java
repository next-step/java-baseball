package view;

import domain.MenuNumber;
import domain.UserNumber;

import java.util.Scanner;

public class InputView {

    public static final String USER_NUMBER = "숫자를 입력해 주세요 : ";
    public static final String ERROR_MESSAGE = "올바른 숫자를 입력해 주세요.";
    public static final String MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
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

    public MenuNumber getMenu() {
        System.out.println(MENU_MESSAGE);
        MenuNumber menuNumber;
        try {
            menuNumber = new MenuNumber(scanner.nextLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(ERROR_MESSAGE);
            menuNumber = getMenu();
        }
        return menuNumber;
    }
}

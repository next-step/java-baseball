package baseball.ui.impl;

import baseball.ui.UiSystem;

import java.util.Scanner;

/**
 * 콘솔 ui를 사용하기위한 객체
 */
public class ConsoleUiSystem implements UiSystem {
    private final Scanner scanner = new Scanner(System.in);

    // check validation
    @Override
    public String gameInput() {
        return scanner.nextLine();
    }

    @Override
    public void display(String data) {
        System.out.println(data);
    }

}

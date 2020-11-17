package com.sang5c.baseball.ui;

import java.util.Scanner;

public class InputView {

    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String PLEASE_INPUT_CONTINUE = "계속하려면 엔터, 그만하려면 exit 입력";

    public static String getInputToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PLEASE_INPUT_CONTINUE);
        return scanner.nextLine();
    }

    public static String getUserNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(PLEASE_INPUT_NUMBER);
        return scanner.nextLine();
    }

}

package com.sang5c.baseball.ui;

import java.util.Scanner;

public class InputView {

    public static String getInputToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계속하려면 엔터, 그만하려면 exit 입력");
        return scanner.nextLine();
    }

    public static String getUserNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

}

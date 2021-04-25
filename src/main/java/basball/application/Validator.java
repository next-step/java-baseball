package basball.application;

import java.util.Scanner;

public class Validator {

    Scanner sc = new Scanner(System.in);

    public String input() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = sc.nextLine();
        if (!checkString(input)) {
            return input();
        }
        return input;
    }

    private boolean checkString(String number) {
        if (number.length() != 3) {
            System.out.println("3자리 숫자를 입력해주세요");
            return false;
        }

        return true;
    }

}

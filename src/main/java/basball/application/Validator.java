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

        if (!checkRange(number)) {
            return false;
        }

        if (!checkSame(number)) {
            return false;
        }

        return true;
    }

    private boolean checkRange(String number) {
        if (checkNumberRange(number.charAt(0) - '0')
                || checkNumberRange(number.charAt(1) - '0')
                || checkNumberRange(number.charAt(2) - '0')) {
            System.out.println("1~9 사이의 수만 입력할 수 있습니다.");
            return false;
        }

        return true;
    }

    private boolean checkSame(String number) {
        if (checkSameNumber(number.charAt(0)-'0', number.charAt(1)-'0')
                || checkSameNumber(number.charAt(0)-'0', number.charAt(2)-'0')
                || checkSameNumber(number.charAt(1)-'0', number.charAt(2)-'0') ) {
            System.out.println("서로 다른 숫자를 입력해주세요.");
            return false;
        }
        return true;
    }

    private boolean checkNumberRange(int num) {
        return num < 1 || num > 9;
    }

    private boolean checkSameNumber(int num, int num2) {
        return num == num2;
    }
}

package numbaseball;

import java.util.Scanner;

public class Ui {

    private static Scanner sc = new Scanner(System.in);
    public static int getUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNum = sc.next();
        return Integer.parseInt(userNum);
    }
}

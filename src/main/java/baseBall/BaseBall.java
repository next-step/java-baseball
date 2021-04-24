package baseBall;

import java.util.Scanner;

public class BaseBall {

    private String userNumber = "";

    public void gameStart() {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.");

        userNumber = sc.next();

    }
}

package baseball;

import java.util.Scanner;

public class Player {

    private String value;

    public Player() {
        value = "";
    }

    public void inputValue() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        value = Integer.toString(scanner.nextInt());
    }

}

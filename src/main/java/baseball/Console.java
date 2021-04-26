package baseball;

import java.util.Scanner;

public class Console {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        System.out.print(scanner.nextInt());
        scanner.close();
    }

    public static void main(String[] args) {

    }

}

package playball.io;

import playball.domain.HintResults;

import java.util.Scanner;

public class BaseBallDisplay {

    public static Scanner scanner = new Scanner(System.in);

    public static int input() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }

    public void output(HintResults hintResults) {

    }
}

package baseball.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public static String inputNumber() {
        return scan.next();
    }

    public static boolean askEnd() {
        int isFinish = scan.nextInt();
        if(isFinish != 1 && isFinish != 2){
            throw new IllegalArgumentException("1 혹은 2만 입력해야 합니다.");
        }
        if(isFinish == 1){
            return true;
        }
        return false;
    }
}

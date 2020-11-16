package baseball;

import baseball.input.BaseBallInputer;

public class Main {
    public static void main(String[] args) {
        boolean isExit = true;

        while (isExit) {
            System.out.print("숫자를 입력해주세요 : ");
            BaseBallInputer.input(System.in);
            isExit = false;
        }
    }
}

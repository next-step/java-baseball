package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public int inputNumber() throws InputMismatchException {
        System.out.println("숫자를 입력해주세요.");
        return new Scanner(System.in).nextInt();
    }

    public int inputContinue() throws InputMismatchException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작할려면 1, 종료할려면 2를 입력하세요.");
        return new Scanner(System.in).nextInt();
    }
}

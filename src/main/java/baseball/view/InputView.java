package baseball.view;

import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);
    public int printInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        return sc.nextInt();
    }
}

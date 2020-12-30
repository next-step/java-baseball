package practice.baseball;

import java.util.Scanner;

public class BaseballUI {

    private BaseballLogic objBase;
    private String strInput;

    public static void main(String[] args) {
        BaseballUI objUI = new BaseballUI();
        do {
            objUI.loopMainFunction();
        } while(true);
    }

    public void loopMainFunction() {
        this.objBase.setNumbers();
        this.inputNumber();
    }

    public void inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        this.strInput = scan.nextLine();
    }


}

package practice.baseball;

import java.util.Scanner;

public class BaseballUI {

    private BaseballLogic objBase;

    public static void main(String[] args) {
        BaseballUI objUI = new BaseballUI();
        do {
            objUI.objBase = new BaseballLogic();
            objUI.objBase.setBaseballNumbers();
            objUI.loopUserGame();
            break;
        } while(true);
    }

    public void loopUserGame() {
        String sUserNumber = this.inputUserNumber();
        this.objBase.compareUserNumberWithNumber(sUserNumber);
    }

    public String inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


}

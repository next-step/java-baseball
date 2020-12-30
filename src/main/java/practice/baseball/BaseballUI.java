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
        int[] arrUserNumber = this.inputUserNumber();
        this.objBase.compareUserNumberWithNumber(arrUserNumber);
    }

    public int[] inputUserNumber() {
        int[] arrUserNumber = new int[3];
        System.out.println("숫자를 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        int iInputNumber = scan.nextInt();
        for( int i = 0; i < 3; i++ ) {
            arrUserNumber[i] = iInputNumber % 10;
            iInputNumber /= 10;
        }
        return arrUserNumber;
    }


}

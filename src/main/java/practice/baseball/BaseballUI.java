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
            System.out.println("3개 숫자를 모두 맞히셨습니다!");
        } while(objUI.doRestart());

        System.out.print("게임 종료");
    }

    public void loopUserGame() {
        int[] arrStrikeAndBallCount;

        do {
            int[] arrUserNumber = this.inputUserNumber();
            this.objBase.compareUserNumberWithNumber(arrUserNumber);
            arrStrikeAndBallCount = this.objBase.getCounts();
            this.printOutputStrikeAndBall(arrStrikeAndBallCount);
        } while(arrStrikeAndBallCount[0] != 3);
    }

    public int[] inputUserNumber() {
        int[] arrUserNumber = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        int iInputNumber = new Scanner(System.in).nextInt();

        for( int i = 0; i < 3; i++ ) {
            arrUserNumber[i] = iInputNumber % 10;
            iInputNumber /= 10;
        }

        return arrUserNumber;
    }

    public void printOutputStrikeAndBall(int[] arrStrikeAndBallCount ) {
        String strOutput = this.makeOutputString(arrStrikeAndBallCount[0], arrStrikeAndBallCount[1]);
        System.out.println(strOutput);
    }

    private String makeOutputString( int iStrikeCount, int iBallCount ) {
        String strOutput = "";

        if( iStrikeCount > 0 )
            strOutput += iStrikeCount + "스트라이크 ";
        if( iBallCount > 0 )
            strOutput += iBallCount + "볼";
        if( strOutput.equals("") )
            return "낫싱";
        return strOutput;
    }

    private boolean doRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int iUserInputForRestart = new Scanner(System.in).nextInt();

        if( iUserInputForRestart == 1 )
            return true;
        return false;
    }

}

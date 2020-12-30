package practice.baseball;

import java.util.Arrays;

public class BaseballLogic {

    private int[] arrNumber;
    private int iStrikeCount;
    private int iBallCount;

    public void setBaseballNumbers() {
        this.arrNumber = new int[3];
        do {
            this.arrNumber[0] = (int) ((Math.random()*10000) % 9) + 1;
            this.arrNumber[1] = (int) ((Math.random()*10000) % 9) + 1;
            this.arrNumber[2] = (int) ((Math.random()*10000) % 9) + 1;
        } while(checkValidNumber(this.arrNumber));
    }

    private boolean checkValidNumber(int[] arrNumber) {
        if( arrNumber[0] == arrNumber[1] || arrNumber[1] == arrNumber[2] || arrNumber[0] == arrNumber[2] )
            return true;
        return false;
    }

    public void compareUserNumberWithNumber(int[] arrUserNumber) {
        this.iBallCount = 0;
        this.iStrikeCount = 0;
        for(int i = 0; i < arrUserNumber.length; i++) {
            int iStrike = this.isStrike(arrUserNumber[i] , i);
            this.iBallCount += this.isBall(arrUserNumber[i]) - iStrike;
            this.iStrikeCount += iStrike;
        }
    }

    private int isStrike(int iNumber, int index) {
        if( this.arrNumber[index] == iNumber )
            return 1;
        return 0;
    }

    private int isBall(int iNumber) {
        int iBallCount = Arrays.asList(this.arrNumber).indexOf(iNumber);
        if ( iBallCount > -1 )
            return iBallCount;
        return 0;
    }

}

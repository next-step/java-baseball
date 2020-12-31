/*
 * File     : BaseballLogic.java
 * Date     : 2020. 12. 31
 * Copyright 2020 Eli Nabro Eau
 */
package practice.baseball;

/*
 * Class    : BaseballLogic
 * Version  : 1.0
 * author   : Eli
 *
 * Baseball game Logic control class
 */
public class BaseballLogic {

    private int[] arrNumber;    /* Computer Baseball number */
    private int iStrikeCount;   /* strike count */
    private int iBallCount;     /* ball count */

    /* make Baseball number of computer */
    public int[] setBaseballNumbers() {
        this.arrNumber = new int[3];

        do {
            this.arrNumber[0] = (int) ((Math.random()*10000) % 9) + 1;
            this.arrNumber[1] = (int) ((Math.random()*10000) % 9) + 1;
            this.arrNumber[2] = (int) ((Math.random()*10000) % 9) + 1;
        } while(checkValidNumber(this.arrNumber));
        return this.arrNumber;
    }

    /* check validation of computer number */
    private boolean checkValidNumber(int[] arrNumber) {
        if( arrNumber[0] == arrNumber[1] || arrNumber[1] == arrNumber[2] || arrNumber[0] == arrNumber[2] )
            return true;
        return false;
    }

    /* compare user number and computer number */
    public int compareUserNumberWithNumber(int[] arrUserNumber) {
        this.iBallCount = 0;
        this.iStrikeCount = 0;

        for(int i = 0; i < arrUserNumber.length; i++) {
            int iStrike = this.isStrike(arrUserNumber[i] , i);
            this.iBallCount += this.isBall(arrUserNumber[i]) - iStrike;
            this.iStrikeCount += iStrike;
        }

        return iStrikeCount + iBallCount;
    }

    /* check strike of number */
    private int isStrike(int iNumber, int index) {
        if( this.arrNumber[index] == iNumber )
            return 1;
        return 0;
    }

    /* check ball of number */
    private int isBall(int iNumber) {
        boolean bBall = false;
        int index = 0;

        do {
            bBall = isMatched(iNumber, this.arrNumber[index++]);
        } while(!bBall && index < 3);

        if( bBall )
            return 1;
        return 0;
    }

    /* check match number */
    private boolean isMatched(int iUserNumber, int iComputerNumber) {
        if( iUserNumber == iComputerNumber )
            return true;
        return false;
    }

    /* return strike and ball count */
    public int[] getCounts() {
        int[] arrStrikeAndBallCount = new int[2];

        arrStrikeAndBallCount[0] = this.iStrikeCount;
        arrStrikeAndBallCount[1] = this.iBallCount;

        return arrStrikeAndBallCount;
    }

    /* set computer number for test */
    public void setBaseballNumberUsingArray(int[] paraNumber) {
        this.arrNumber = new int[3];
        for(int i = 0; i < paraNumber.length; i++) {
            this.arrNumber[i] = paraNumber[i];
        }
    }

    /* set strike and ball count for test */
    public void setStrikeAndBallValue(int paraStrikeCount,int paraBallCount ) {
        this.iStrikeCount = paraStrikeCount;
        this.iBallCount = paraBallCount;
    }

}

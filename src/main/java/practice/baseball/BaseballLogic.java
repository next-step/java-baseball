package practice.baseball;

public class BaseballLogic {

    private int[] arrNumber;
    private int iStrikeCount;
    private int iBallCount;

    public int[] setBaseballNumbers() {
        this.arrNumber = new int[3];

        do {
            this.arrNumber[0] = (int) ((Math.random()*10000) % 9) + 1;
            this.arrNumber[1] = (int) ((Math.random()*10000) % 9) + 1;
            this.arrNumber[2] = (int) ((Math.random()*10000) % 9) + 1;
        } while(checkValidNumber(this.arrNumber));
        return this.arrNumber;
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
        boolean bBall = false;
        int index = 0;

        do {
            bBall = isMatched(iNumber, this.arrNumber[index++]);
        } while(!bBall && index < 3);

        if( bBall )
            return 1;
        return 0;
    }

    private boolean isMatched(int iUserNumber, int iComputerNumber) {
        if( iUserNumber == iComputerNumber )
            return true;
        return false;
    }

    public int[] getCounts() {
        int[] arrStrikeAndBallCount = new int[2];

        arrStrikeAndBallCount[0] = this.iStrikeCount;
        arrStrikeAndBallCount[1] = this.iBallCount;

        return arrStrikeAndBallCount;
    }

}

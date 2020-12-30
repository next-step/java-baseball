package practice.baseball;

public class BaseballLogic {

    private String sNumber;
    private int[] iNumber;
    private int iStrikeCount;
    private int iBallCount;

    public void setBaseballNumbers() {
        this.iNumber = new int[3];
        do {
            this.iNumber[0] = (int) ((Math.random()*10000) % 9) + 1;
            this.iNumber[1] = (int) ((Math.random()*10000) % 9) + 1;
            this.iNumber[2] = (int) ((Math.random()*10000) % 9) + 1;
        } while(checkValidNumber());
    }

    public boolean checkValidNumber() {
        if( iNumber[0] == iNumber[1] || iNumber[1] == iNumber[2] || iNumber[0] == iNumber[2] )
            return true;
        return false;
    }

    public void compareUserNumberWithNumber(String sUserNumber) {

    }


}

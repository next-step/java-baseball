package baseBall.util;

public class Discrimination {

    private int strikeCount = 0;
    private int ballCount = 0;

    private StringBuilder systemNumbers;
    static CreateNumber createNumber;



    public int getStrikeCount(String systemNumber, String userNumber, int index) {

        if(systemNumber.indexOf(userNumber) == index) {
            strikeCount++;
        }

        return strikeCount;
    }

    public int getBallCount(String SystemNumber, String userNumber, int index) {
        if(SystemNumber.indexOf(userNumber) > -1 && SystemNumber.indexOf(userNumber) != index) {
            ballCount++;
        }

        return ballCount;
    }

    public void getSystemNumber() {
        systemNumbers = createNumber.generateNumbers();
    }


}

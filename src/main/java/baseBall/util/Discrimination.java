package baseBall.util;

public class Discrimination {

    private int strikeCount = 0;
    private int ballCount = 0;

    private StringBuilder systemNumbers;
    static CreateNumber createNumber;

    public void match (String systemNumber, String userNumber) {
        for(int i=0; i < userNumber.length(); i++) {
            getStrikeCount(systemNumber, userNumber.charAt(i), i);
            getBallCount(systemNumber, userNumber.charAt(i), i);
        }

    }



    public void getStrikeCount(String systemNumber, char userNumber, int index) {

        if(systemNumber.indexOf(userNumber) == index) {
            strikeCount++;
        }

    }

    public void getBallCount(String SystemNumber, char userNumber, int index) {
        if(SystemNumber.indexOf(userNumber) > -1 && SystemNumber.indexOf(userNumber) != index) {
            ballCount++;
        }

    }


}

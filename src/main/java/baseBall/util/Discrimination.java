package baseBall.util;

import java.util.Scanner;

public class Discrimination {

    private final int MAX_STRIKE = 3;

    private int strikeCount = 0;
    private int ballCount = 0;

    public boolean checkVictory() {
        boolean isVictory = false;

        if(strikeCount == MAX_STRIKE) {
            isVictory = true;
        }

        return isVictory;

    }

    public String match (String systemNumber, String userNumber) {

        strikeCount = 0;
        ballCount = 0;
        System.out.println(strikeCount);

        StringBuilder gameResult = new StringBuilder();

        for(int i=0; i < userNumber.length(); i++) {
            getStrikeCount(systemNumber, userNumber.charAt(i), i);
            getBallCount(systemNumber, userNumber.charAt(i), i);
        }

        if(strikeCount > 0 || ballCount > 0) {
            gameResult.append(strikeCount);
            gameResult.append(" 스트라이크 ");
            gameResult.append(ballCount);
            gameResult.append(" 볼");
        }

        if(strikeCount == 0 && ballCount == 0) {
            gameResult.append("낫싱");
        }

        return gameResult.toString();

    }

    public int getStrikeCount(String systemNumber, char userNumber, int index) {

        if(systemNumber.indexOf(userNumber) == index) {
            strikeCount++;
        }

        return strikeCount;

    }

    public int getBallCount(String SystemNumber, char userNumber, int index) {
        if(SystemNumber.indexOf(userNumber) > -1 && SystemNumber.indexOf(userNumber) != index) {
            ballCount++;
        }

        return ballCount;

    }


}

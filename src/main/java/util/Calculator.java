package util;

public class Calculator {
    int ballCount;
    int strikeCount;

    public void initCount(){
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public int getBallCount(char player, int index, String computer){
        int returnCount = computer.indexOf(player);
        if(returnCount != -1 && returnCount != index) return 1;
        return 0;
    }

    public String getBallString(int ballCount){
        if(ballCount == 0) return "";
        return ballCount + "볼";
    }

  

}

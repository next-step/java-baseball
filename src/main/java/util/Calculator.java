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

    public int getStrikeCount(char player, char computer){
        if(player == computer) return 1;
        return 0;
    }

    public String getStrikeString(int strikeCount){
        if(strikeCount == 0) return "";
        return strikeCount + "스트라이크 ";
    }

    public String getCalculatorResult(String player, String computer){
        initCount();
        for(int i=0;i<3;i++) {
            ballCount += getBallCount(player.charAt(i), i, computer);
            strikeCount += getStrikeCount(player.charAt(i), computer.charAt(i));
        }
        if(strikeCount == 3) return "3개의 숫자를 모두 맞히셨습니다 ! 게임 종료";
        if(ballCount == 0 && strikeCount == 0) return "낫씽 ( 아웃 )";
        return getStrikeString(strikeCount) + getBallString(ballCount);
    }

}

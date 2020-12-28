package game;

import common.GameResultPhrases;

public class GameScoreInfo {
    int strikeCount;
    int ballCount;
    private final int GAME_NUMBER_COUNT = 3;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public String makeScoreResultString(){
        StringBuilder resultStringBuilder = new StringBuilder();

        if(strikeCount == GAME_NUMBER_COUNT){
            resultStringBuilder.append(GameResultPhrases.SUCCESS);
            return resultStringBuilder.toString();
        }

        if(strikeCount == 0 && ballCount == 0){
           resultStringBuilder.append(GameResultPhrases.FAIL);
            return resultStringBuilder.toString();
        }

        if(strikeCount > 0){
            resultStringBuilder.append(strikeCount);
            resultStringBuilder.append(GameResultPhrases.DELIMETER);
            resultStringBuilder.append(GameResultPhrases.STRIKE);
            resultStringBuilder.append(GameResultPhrases.DELIMETER);
        }

        if(ballCount > 0){
            resultStringBuilder.append(ballCount);
            resultStringBuilder.append(GameResultPhrases.BALL);
        }

        return resultStringBuilder.toString().trim();
    }
}

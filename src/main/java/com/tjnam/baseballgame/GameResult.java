package com.tjnam.baseballgame;

public class GameResult {

    public int strike;
    public int ball;

    public GameResult(){
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike(){
        this.strike++;
    }

    public void addBall(){
        this.ball++;
    }

    public String getResultString() {
        StringBuffer resultString = new StringBuffer();
        if (this.strike == 0 && this.ball == 0) {
            return this.createNothingString();
        }

        if (this.strike > 0) {
            resultString.append(this.createStrikeString());
        }

        if (this.ball > 0) {
            resultString.append(this.createBallString());
        }
        return resultString.toString().trim();
    }

    private String createNothingString(){
        String nothing = "낫싱";
        return nothing;
    }

    private String createStrikeString(){
        StringBuffer strikeString = new StringBuffer();
        strikeString.append(Integer.toString(this.strike));
        strikeString.append(" 스트라이크 ");
        return strikeString.toString();
    }

    private String createBallString(){
        StringBuffer ballString = new StringBuffer();
        ballString.append(Integer.toString(this.ball));
        ballString.append(" 볼");
        return ballString.toString();
    }
}

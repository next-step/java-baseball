package me.mkhwang.baseball.domain;

/**
 * Created by mkhwang on 2021/04/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class BallCounter {
    private String userBall;
    private String computerBall;

    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean noting = false;

    public BallCounter(String userBall, String computerBall) {
        this.userBall = userBall;
        this.computerBall = computerBall;

        count();
    }

    private void count() {
        for (int i = 0; i < userBall.length(); i++) {
            strikeAndBallCount(i);
        }

        if(strikeCount == 0 && ballCount == 0 ){
            this.noting = true;
        }
    }

    private void strikeAndBallCount(int round) {
        boolean strike = compareStrike(round);
        compareBall(strike, round);
    }

    private boolean compareStrike(int round){
        if(isSameBall(round, round)) {
            this.strikeCount++;
            return true;
        }
        return false;
    }

    private void compareBall(boolean strike, int round) {
        if(strike) return;

        for (int i = 0; i < computerBall.length(); i++) {
            ballCheck(round, i);
        }
    }

    private void ballCheck(int userIndex, int computerIndex) {
        if(isSameBall(userIndex, computerIndex)) {
            this.ballCount++;
        }
    }

    private boolean isSameBall(int userIndex, int computerIndex) {
        return userBall.charAt(userIndex) == computerBall.charAt(computerIndex);
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNoting() {
        return noting;
    }
}

package baseballgame.referee;

import baseballgame.ball.Ball;
import baseballgame.constant.BallCount;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Referee {
    public boolean judgementGame(LinkedHashSet<Ball> playerBalls, LinkedHashSet<Ball> computerBalls) {
        int strike = judgeStrike(playerBalls, computerBalls);
        int ball = judgeBall(playerBalls, computerBalls) - strike;
        if(strike==BallCount.COUNT){
            return true;
        }
        if(strike+ball==0){
            System.out.println("낫씽");
            return false;
        }
        System.out.println("스트라이크 : "+strike+"\t볼 : "+ball);
        return false;
    }

    public int judgeStrike(LinkedHashSet<Ball> playerBalls, LinkedHashSet<Ball> computerBalls) {
        int strike = 0;
        Iterator<Ball> playerBallIterator= playerBalls.iterator();
        Iterator<Ball> computerBallIterator= computerBalls.iterator();
        for (int i = 0; i < BallCount.COUNT; i++) {
            Ball playerBall = playerBallIterator.next();
            Ball computerBall = computerBallIterator.next();
            if (isEqualBall(playerBall, computerBall)) {
                strike++;
            }
        }
        return strike;
    }

    public int judgeBall(LinkedHashSet<Ball> playerBalls, LinkedHashSet<Ball> computerBalls) {
        Set<Ball> ballSet = new HashSet<>(playerBalls);
        ballSet.retainAll(computerBalls);
        return ballSet.size();
    }

    public boolean isEqualBall(Ball playerBall, Ball computerBall) {
        if (playerBall.equals(computerBall))
            return true;
        return false;
    }
}
package me.mkhwang.baseball.domain;

import me.mkhwang.baseball.type.GameType;
import me.mkhwang.baseball.util.BaseballValid;

import java.util.Random;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class ComputerBallGenerator extends BaseballValid {

    private String ballNumber;

    public ComputerBallGenerator() {
        makeBallCount();
    }

    private void makeBallCount() {
        String ball = "";
        while (ball.length() < GameType.BALL_LENGTH.getType()){
            ball = makeBall(ball);
        }
        this.ballNumber = ball;
    }

    private String makeBall(String makeBall) {
        String number = extractNumber();
        if(isBaseballDuplicateValid(makeBall + number)){
            makeBall += number;
        }
        return makeBall;
    }

    private String extractNumber() {
        int i = new Random().nextInt(GameType.MAX_NUMBER.getType()) + GameType.MIN_NUMBER.getType();
        String number = String.valueOf(i);
        return number;
    }

    public String getBallNumber() {
        return ballNumber;
    }
}

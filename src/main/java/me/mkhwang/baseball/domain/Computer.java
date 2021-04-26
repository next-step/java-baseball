package me.mkhwang.baseball.domain;

import me.mkhwang.baseball.util.BaseballValid;

import java.util.Random;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class Computer {

    private static final int BALL_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private String ballNumber;
    private BaseballValid baseballValid = new BaseballValid();

    public Computer() {
        makeBallCount();
        System.out.println(this.ballNumber);
    }

    private void makeBallCount() {
        String ball = "";
        while (ball.length() < BALL_LENGTH){
            ball = makeBall(ball);
        }
        this.ballNumber = ball;
    }

    private String makeBall(String makeBall) {
        String number = extractNumber();
        if(baseballValid.isBaseballDuplicateValid(makeBall + number)){
            makeBall += number;
        }
        return makeBall;
    }

    private String extractNumber() {
        int i = new Random().nextInt(MAX_NUMBER) + MIN_NUMBER;
        String number = String.valueOf(i);
        return number;
    }

    public String getBallNumber() {
        return ballNumber;
    }
}

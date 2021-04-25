package com.baseball.precourse.baseball;

import com.baseball.precourse.util.DigitRandom;
import com.baseball.precourse.util.DigitString;

public class Player {
    private DigitString numbers;

    public Player() {
        this(DigitRandom.generate(Ball.BALL_COUNT));
    }

    public Player(String numbers) {
        this.numbers = new DigitString(numbers);
    }

    public Score hit(Ball ball){
        return new Score(
                countStrike(ball),
                countBall(ball)
        );
    }

    private int countStrike(final Ball ball){
        return numbers.matchPosCount(ball.getValue());
    }

    private int countBall(final Ball ball){
        return numbers.matchCount(ball.getValue()) - numbers.matchPosCount(ball.getValue());
    }
}

package com.demo.baseball;

import java.util.List;
import java.util.Random;

public class BallsController {

    private Balls randomBalls;
    private final Random random = new Random();

    public BallsController() {
        this.randomBalls = new Balls();
    }

    public Balls getRandomBalls() {
        return randomBalls;
    }

    /**
     * 랜덤한 서로 다른 숫자 3개를 가지는 리스트를 세팅한다.
     * @return randomBalls
     */
    public List<Integer> setRandomBalls() {
        for (int i = 0; i < this.randomBalls.getListSize(); i++) {
            this.randomBalls.getBalls().add(this.makeRandomBall());
        }

        return this.randomBalls.getBalls();
    }

    /**
     * 하나의 랜덤한 숫자(1~9)를 리턴한다.
     * @return randomBall
     */
    public int makeRandomBall() {
        int number = 0;

        while (true) {
            number = this.random.nextInt(10);
            if (number != 0 && !this.randomBalls.getBalls().contains(number)) {
                return number;
            }
        }
    }

}

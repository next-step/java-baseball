package com.baseball;

import java.util.Random;

public class Game {
    // 컴퓨터가 랜덤으로 생성한 숫자를 3자리로 분리
    Integer n1;
    Integer n2;
    Integer n3;

    // 사용자가 입력한 숫자를 3자리로 분리
    Integer i1;
    Integer i2;
    Integer i3;

    public Integer getRandomNumber() {
        return randomNumber;
    }

    Integer randomNumber;

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    Integer strike;
    Integer ball;

    /**
     * 1~9까지 세자리 숫자를 랜덤으로 생성
     */
    public Game() {
        Random random = new Random();

        this.n1 = random.nextInt(8) + 1;

        do {
            this.n2 = random.nextInt(8) + 1;
        } while (this.n1 == this.n2);

        do {
            this.n3 = random.nextInt(8) + 1;
        } while (this.n3 == this.n1 || this.n3 == this.n2);

        this.randomNumber = (this.n3 * 100) + (this.n2 * 10) + this.n1;
    }


    /**
     * 테스트를 위하여 세자리 숫자를 랜덤으로 생성하지 않고 바로 지정할 수 있도롬 함
     * @param n1    1~9까지의 숫자 첫번째
     * @param n2    1~9까지의 숫자 두번째
     * @param n3    1~9까지의 숫자 세번째
     */
    public Game(Integer n1, Integer n2, Integer n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }


    /**
     * 사용자가 입력한 세자리 숫자로 스트라이크와 볼의 갯수를 구함.
     * @param inputNumber   사용자가 추측한 세자리 숫자
     */
    public void inputNumber(Integer inputNumber) {
        this.i1 = inputNumber / 100;
        this.i2 = (inputNumber - this.i1 * 100) / 10;
        this.i3 = inputNumber % 10;

        countStrike();
        countBall();
    }


    /**
     * 스트라이크의 갯수를 계산한다.
     */
    private void countStrike() {
        this.strike = 0;

        if (this.i1 == this.n1)
            this.strike++;
        if (this.i2 == this.n2)
            this.strike++;
        if (this.i3 == this.n3)
            this.strike++;
    }

    /**
     * 볼의 갯수를 계산한다.
     */
    private void countBall() {
        this.ball = 0;

        if ((this.i1 == this.n2) || (this.i1 == this.n3))
            this.ball++;
        if ((this.i2 == this.n3) || (this.i2 == this.n1))
            this.ball++;
        if ((this.i3 == this.n1) || (this.i3 == this.n2))
            this.ball++;
    }
}

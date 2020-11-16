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

    public Game(Integer n1, Integer n2, Integer n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public void inputNumber(Integer inputNumber) {
        this.i1 = inputNumber / 100;
        this.i2 = (inputNumber - this.i1 * 100) / 10;
        this.i3 = inputNumber % 10;
    }

    public Integer countStrike(Integer inputNumber) {
        Integer strike = 0;
        inputNumber(inputNumber);

        if (this.i1 == this.n1)
            strike++;
        if (this.i2 == this.n2)
            strike++;
        if (this.i3 == this.n3)
            strike++;

        return strike;
    }

    public Integer countBall(Integer inputNumber) {
        Integer ball = 0;
        inputNumber(inputNumber);

        if ((this.i1 == this.n2) || (this.i1 == this.n3))
            ball++;
        if ((this.i2 == this.n3) || (this.i2 == this.n1))
            ball++;
        if ((this.i3 == this.n1) || (this.i3 == this.n2))
            ball++;

        return ball;
    }
}

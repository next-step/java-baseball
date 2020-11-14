package com.baseball;

import java.util.Random;

public class Game {
    Integer n1;
    Integer n2;
    Integer n3;

    public Game() {
    }

    public Game(Integer n1, Integer n2, Integer n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public Integer randomNumber() {
        Random random = new Random();

        n1 = random.nextInt(8) + 1;

        do {
            n2 = random.nextInt(8) + 1;
        } while (n1 == n2);

        do {
            n3 = random.nextInt(8) + 1;
        } while (n3 == n1 || n3 == n2);

        return (n1 * 100) + (n2 * 10) + n3;
    }

    public Integer countStrike(Integer inputNumber) {
        Integer a1 = inputNumber / 100;
        Integer a2 = (inputNumber - a1 * 100) / 10;
        Integer a3 = inputNumber % 10;

        Integer strike = 0;

        if (a1 == this.n1)
            strike++;
        if (a2 == this.n2)
            strike++;
        if (a3 == this.n3)
            strike++;

        return strike;
    }

    public Integer countBall(Integer inputNumber) {
        Integer a1 = inputNumber / 100;
        Integer a2 = (inputNumber - a1 * 100) / 10;
        Integer a3 = inputNumber % 10;

        Integer ball = 0;
        if ((a1 == this.n2) || (a1 == this.n3))
            ball++;
        if ((a2 == this.n3) || (a2 == this.n1))
            ball++;
        if ((a3 == this.n1) || (a3 == this.n2))
            ball++;

        return ball;
    }
}

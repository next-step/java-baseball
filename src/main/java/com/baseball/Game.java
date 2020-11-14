package com.baseball;

import java.util.Random;

public class Game {

    public Integer randomNumber() {
        Random random = new Random();

        Integer n1, n2, n3;
        n1 = random.nextInt(8) + 1;

        do {
            n2 = random.nextInt(8) + 1;
        } while (n1 == n2);

        do {
            n3 = random.nextInt(8) + 1;
        } while (n3 == n1 || n3 == n2);

        return (n1 * 100) + (n2 * 10) + n3;
    }

}

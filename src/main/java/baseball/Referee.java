package baseball;

import java.util.Random;

public class Referee {
    private final Numbers numbers;

    public Referee() {
        Random random = new Random();
        int firstNumber = random.nextInt();
        this.numbers = new Numbers();
    }
}

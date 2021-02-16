package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final List<BallNumber> BALL_NUMBER_GENERATOR = new ArrayList<>();

    private BaseBallNumbers baseBallNumbers;

    static {
        for (int i = 1; i < 10; i++) {
            BALL_NUMBER_GENERATOR.add(BallNumber.of(i));
        }
    }

    private Computer() {
        this.baseBallNumbers = BaseBallNumbers.of();
    }

    public BaseBallNumbers getBaseBallNumbers() {
        return baseBallNumbers;
    }

    public void shuffleBaseBallNumbers() {
        this.baseBallNumbers = BaseBallNumbers.of(generateBallNumbers());
    }

    public void startChecking(Player player) {
        baseBallNumbers.checkStrikeBall(player);
    }

    private static List<BallNumber> generateBallNumbers () {
        Collections.shuffle(BALL_NUMBER_GENERATOR);
        return BALL_NUMBER_GENERATOR.subList(0,3);
    }

    public static Computer of () {
        return new Computer();
    }
}

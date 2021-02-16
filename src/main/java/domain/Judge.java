package domain;

import java.util.stream.IntStream;

public class Judge {

    public BallCount makeDecision(final Numbers numbers1, final Numbers numbers2) {
        int numberOfDigits = numbers1.numberOfDigits();
        int balls = (int) IntStream.range(0, numberOfDigits)
                .filter(i -> !numbers1.existsSameNumberAt(i, numbers2))
                .filter(i -> numbers1.contains(i, numbers2))
                .count();
        int strikes = (int) IntStream.range(0, numberOfDigits)
                .filter(i -> numbers1.existsSameNumberAt(i, numbers2))
                .count();
        return new BallCount(balls, strikes);
    }
}

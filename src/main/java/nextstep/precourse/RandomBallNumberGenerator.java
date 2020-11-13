package nextstep.precourse;

import nextstep.precourse.domain.BallNumber;
import nextstep.precourse.domain.BallNumbers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomBallNumberGenerator {

    public static BallNumbers generate() {
        Set<Integer> randomIntSet = generateRandomInt();

        Set<BallNumber> ballNumberSet = new HashSet<>();
        int position = 1;
        for(int number : randomIntSet) {
            ballNumberSet.add(new BallNumber(number, position));
            position++;
        }

        return new BallNumbers(ballNumberSet);
    }

    public static Set<Integer> generateRandomInt() {
        Random random = new Random();

        Set<Integer> randomIntSet = new HashSet<>();
        while(randomIntSet.size() < 3) {
            randomIntSet.add(random.nextInt(9) + 1);
        }

        return randomIntSet;
    }
}

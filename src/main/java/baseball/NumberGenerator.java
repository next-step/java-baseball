package baseball;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private final List<Integer> numbers = new ArrayList<>();
    private final Random rand = new SecureRandom(); //

    public NumberGenerator() {
        for (int i = 1; i < 9; i++) {
            numbers.add(i);
        }
    }

    public Integer getRandomNumber() {
        int i = rand.nextInt(numbers.size());
        Integer integer = numbers.get(i);
        numbers.remove(integer);
        return integer;
    }
}

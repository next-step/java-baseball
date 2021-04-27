package baseball.numbergenerator;

import baseball.Target;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class ThreeNumberGenerator implements NumberGenerator {

    @Override
    public Target create() {
        char[] numbers = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        shuffling(numbers);
        return getThreeNumbersFrom(numbers);
    }

    private Target getThreeNumbersFrom(char[] numbers) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(numbers[i]);
        }
        return Target.of(list);
    }

    private void shuffling(char[] numbers) {
        char temp = 0;
        int j = 0;
        for (int i = 0; i < 50; i++) {
            j = RandomUtils.nextInt(0, 8);
            temp = numbers[0];
            numbers[0] = numbers[j];
            numbers[j] = temp;
        }
    }
}

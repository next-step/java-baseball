package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BaseballDigitGenerator {

    private final List<String> availableCharList;
    private final int digits;

    public BaseballDigitGenerator(List<String> availableCharList, int digits) {
        this.availableCharList = availableCharList;
        this.digits = digits;
    }

    List<String> generateRandomDigits(Random random) {
        List<String> shuffledList = getShuffledAvailableCharList(random);
        List<String> randomDigits = new ArrayList<>();
        for (int index = 0; index < this.digits; index++) {
            randomDigits.add(shuffledList.get(index));
        }
        return randomDigits;
    }

    private List<String> getShuffledAvailableCharList(Random random) {
        List<String> shuffledChars = new ArrayList<>(availableCharList);
        Collections.shuffle(shuffledChars, random);
        return shuffledChars;
    }
}

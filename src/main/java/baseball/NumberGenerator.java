package baseball;

import java.util.*;

public class NumberGenerator {

    private final Random rand = new Random();

    public int getUniqueNumber(Set<Integer> numberSet) {
        int number = rand.nextInt(9) + 1;
        while (numberSet.contains(number)) {
            number = rand.nextInt(9) + 1;
        }
        return number;
    }

    public List<Integer> generate() {
        List<Integer> numberList = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            int number = getUniqueNumber(numberSet);
            numberSet.add(number);
            numberList.add(number);
        }
        return numberList;
    }
}
